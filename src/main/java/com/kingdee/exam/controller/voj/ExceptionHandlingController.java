package com.kingdee.exam.controller.voj;

import com.kingdee.exam.voj.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理的控制器.
 */
@ControllerAdvice
public class ExceptionHandlingController {
	/**
	 * 处理MissingServletRequestParameterException异常的方法.
	 * @return 返回一个包含异常信息的ModelAndView对象
	 */
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView badRequestView() {
        return new ModelAndView("/_error/404");
	}
	
	/**
	 * 处理ResourceNotFoundException异常的方法.
	 * @return 返回一个包含异常信息的ModelAndView对象
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView notFoundView() {
        return new ModelAndView("/_error/404");
	}
	
	/**
	 * 处理HttpRequestMethodNotSupportedException异常的方法.
	 * @return 返回一个包含异常信息的ModelAndView对象
	 */
	@ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView methodNotAllowedView() {
        return new ModelAndView("/_error/404");
	}
	
	/**
	 * 处理通用Exception异常的方法.
	 * @param ex - 抛出的异常对象
	 * @return 返回一个包含异常信息的ModelAndView对象
	 */
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ModelAndView internalServerErrorView(
            Exception ex) {
		LOGGER.catching(ex);

        return new ModelAndView("/_error/500");
	}
	
	/**
	 * 日志记录器.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ExceptionHandlingController.class);
}
