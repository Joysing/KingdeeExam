package com.kingdee.exam.config;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailService userDetailService;
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    private static final String[] UNSECURED_RESOURCE_LIST = new String[]{"/static/**", "/code","/","/favicon.ico"};

    @Autowired
    public WebSecurityConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        LoginAuthenticationFilter() {
            AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/login", "POST");
            this.setRequiresAuthenticationRequestMatcher(requestMatcher);
            this.setAuthenticationFailureHandler(authenticationFailureHandler());
            this.setAuthenticationManager(getAuthenticationManager());
            super.setAuthenticationFailureHandler(authenticationFailureHandler());
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            String inputCode = request.getParameter("code");
            String sessionCode = (String) request.getSession().getAttribute("code");
            if (sessionCode==null||!sessionCode.equals(inputCode.toUpperCase())) {
                throw new CaptchaException("captcha code not matched!");
            }
            return super.attemptAuthentication(request, response);
        }
        class CaptchaException extends AuthenticationException {
            CaptchaException(String msg) {
                super(msg);
            }
        }
    }
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(UNSECURED_RESOURCE_LIST);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LoginAuthenticationFilter loginAuthenticationFilter = new LoginAuthenticationFilter();
        loginAuthenticationFilter.setAuthenticationManager(authenticationManager());
        loginAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").anyRequest().authenticated()
                .and()
                .addFilterBefore(loginAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/login")
                .failureHandler(authenticationFailureHandler())
                .successHandler(loginSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access?error")
                .and().logout().permitAll().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler())
                .and().sessionManagement().maximumSessions(10).expiredUrl("/login?error=expired");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return (httpServletRequest, httpServletResponse, authentication) -> {
            try {
                User user = (User) authentication.getPrincipal();
                logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
            } catch (Exception e) {
                logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
            }
            httpServletResponse.sendRedirect("/login");
        };
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
                User userDetails = (User) authentication.getPrincipal();
                Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                logger.info("Authorities : " + roles);

                request.getSession().setAttribute("myUser",userDetails);
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
                if (roles.contains("ROLE_ADMIN")){
                    response.sendRedirect(basePath+"/admin/index.html");
                    return;
                }
                response.sendRedirect(basePath+"/exam/index.html");
            }
        };
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();
        Map<String, String> failureUrlMap = new HashMap<>();
        failureUrlMap.put(BadCredentialsException.class.getName(), "/login?error=password_wrong");
        failureUrlMap.put(LoginAuthenticationFilter.CaptchaException.class.getName(), "/login?error=code_wrong");
        failureHandler.setExceptionMappings(failureUrlMap);
        return failureHandler;
    }
}