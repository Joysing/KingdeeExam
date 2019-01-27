package com.kingdee.exam.controller.voj;

import com.kingdee.exam.voj.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理应用程序公共的请求.
 */
@Controller
@RequestMapping(value="/")
public class DefaultController {

    @Autowired
    public DefaultController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
	 * 显示评测机信息页面.
	 * @return 一个包含评测机信息页面内容的ModelAndView对象
	 */
	@RequestMapping(value="/judgers", method=RequestMethod.GET)
	public ModelAndView judgersView() {
		ModelAndView view = new ModelAndView("misc/judgers");
		view.addObject("languages", languageService.getAllLanguages());
		return view;
	}

	/**
	 * 对于所有未正常映射URL的页面, 显示页面未找到.
	 * @return 返回一个包含异常信息的ModelAndView对象
	 */
	@RequestMapping(value="/*", method=RequestMethod.GET)
	public ModelAndView notFoundView() {
        return new ModelAndView("errors/404");
	}
	
	/**
	 * 显示升级浏览器页面.
	 * @return 一个包含升级浏览器页面内容的ModelAndView对象
	 */
	@RequestMapping(value="/not-supported", method=RequestMethod.GET)
	public ModelAndView notSupportedView() {
        return new ModelAndView("errors/not-supported");
	}
	

	/**
	 * 自动注入的LanguageService对象.
	 * 用于获取评测机页面的编译命令.
	 */
	private final LanguageService languageService;

}
