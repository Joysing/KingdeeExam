package com.kingdee.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping(value = {"/", "/index.html"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/errors/404")
	public ModelAndView errors(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("_error/404");
		return modelAndView;
	}
	
}
