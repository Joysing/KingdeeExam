package com.kingdee.exam.controller;

import com.kingdee.exam.voj.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

	@Autowired
	SubmissionService submissionService;

	@RequestMapping(value = {"/", "/index.html"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/errors/404")
	public ModelAndView errors(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("_error/400");
		return modelAndView;
	}
	
}
