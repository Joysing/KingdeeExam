package com.kingdee.exam.service;

import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ExamService {

	//查询所有开始考试试卷到前端
	List<TestPaper> findAllTestPaper();
	
	//查询选择判断题
	void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session);

	//判题系统
	List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session);

	boolean autoGenerate(HttpSession session, Integer id);

	
}
