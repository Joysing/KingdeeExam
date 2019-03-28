package com.kingdee.exam.controller.admin;

import com.kingdee.exam.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

	@GetMapping("/loginPage")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "不正确的用户名和密码");
		}
		if (logout != null) {
			modelAndView.addObject("msg", "你已经成功退出");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

	public User getUser() { //为了session从获取用户信息,可以配置如下
		User user = new User();
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) user = (User) auth.getPrincipal();
		return user;
	}

	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("_admin/index");
		return modelAndView;
	}

}
