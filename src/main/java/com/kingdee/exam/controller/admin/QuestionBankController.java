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

	private final QuestionBankService questionBankService;

    @Autowired
    public QuestionBankController(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

	@RequestMapping(value = "/question-bank.html")
	public ModelAndView questionBank() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("_admin/question-bank");
		return modelAndView;
	}
	
	/**
	 * 获取所有实体
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllQuestionBank")
	public PageInfo<QuestionBankVo> getAllQuestionBank(@RequestBody PageInfo<QuestionBankVo> pageInfo) {
        return questionBankService.findAllQuestionBank(pageInfo);
	}
	
	/**
	 * 添加题目
	 */
	@ResponseBody
	@RequestMapping(value = "/addQuestionBank")
	public boolean addQuestionBank(@RequestBody QuestionBankVo questionBankVo) {
        return questionBankService.addQuestionBank(questionBankVo);
	}
	
	/**
	 * 删除试卷
	 */
	@ResponseBody
	@RequestMapping(value = "/deletequestionbank")
	public boolean deleteQuestionBank(@RequestBody QuestionBankVo questionBankVo) {
        return questionBankService.deleteQuestionBank(questionBankVo.getQuestionBankId().toString());
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatequestionbank-{id}")
	public boolean updateQuestionBank(@RequestBody QuestionBankVo questionBankVo, @PathVariable String id) {
		questionBankVo.setQuestionBankId(Integer.parseInt(id));
        return questionBankService.updateQuestionBank(questionBankVo);
	}
	
}
