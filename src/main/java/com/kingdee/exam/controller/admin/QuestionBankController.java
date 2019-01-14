package com.kingdee.exam.controller.admin;

import com.github.pagehelper.PageInfo;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class QuestionBankController {

	@Autowired
	private QuestionBankService questionBankService;
	
	/**
	 * 映射主页模板
	 */
	@RequestMapping(value = "/question-bank.html")
	public ModelAndView questionBank() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("_admin/question-bank");
		return modelAndView;
	}
	
	/**
	 * 获取所有实体
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllQuestionBank")
	public PageInfo<QuestionBankVo> getAllQuestionBank(@RequestBody PageInfo<QuestionBankVo> pageInfo) {
		
		
		PageInfo<QuestionBankVo> findAllQuestionBank = questionBankService.findAllQuestionBank(pageInfo);
		
		return findAllQuestionBank;
	}
	
	/**
	 * 添加题目
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addquestionbank")
	public boolean addQuestionBank(@RequestBody QuestionBankVo questionBankVo) {
		
		//添加题目
		boolean addQuestionBank = questionBankService.addQuestionBank(questionBankVo);
		
		return addQuestionBank;
	}
	
	/**
	 * 删除试卷
	 * @param questionBankId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deletequestionbank")
	public boolean deleteQuestionBank(@RequestBody QuestionBankVo questionBankVo) {
		
		boolean deleteQuestionBankState = questionBankService.deleteQuestionBank(questionBankVo.getQuestionBankId().toString());
		
		return deleteQuestionBankState;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatequestionbank-{id}")
	public boolean updateQuestionBank(@RequestBody QuestionBankVo questionBankVo, @PathVariable String id) {
		questionBankVo.setQuestionBankId(Integer.parseInt(id));
		boolean updateQuestionBank = questionBankService.updateQuestionBank(questionBankVo);
		
		return updateQuestionBank;
	}
	
}
