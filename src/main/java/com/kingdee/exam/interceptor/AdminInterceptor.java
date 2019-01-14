package com.kingdee.exam.interceptor;

import com.kingdee.exam.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XiaoBingBy on 2016/11/1.
 */
public class AdminInterceptor implements HandlerInterceptor {

    //拦截前处理
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取Session 如果为空拦截
        User user = (User) httpServletRequest.getSession().getAttribute("myUser");
        //判断是否为空
        if (user!=null) {
        	if (user.getPermission() == 1) {
        		return true;
			}
		}

        httpServletResponse.sendRedirect("/login.html");
        return false;
    }

    //拦截后处理
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //全部完成后处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
