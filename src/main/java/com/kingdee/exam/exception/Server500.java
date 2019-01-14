package com.kingdee.exam.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XiaoBingBy on 2016/11/2. 全局异常处理器 服务器500错误处理跳转页面
 */
public class Server500 implements HandlerExceptionResolver {

	/**
	 *
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param e
	 * @return
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/_error/500");

		return modelAndView;
	}
}