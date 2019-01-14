package com.kingdee.exam.dao;


import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.Times;
import com.kingdee.exam.entity.vo.QuestionBankVo;

import java.util.List;

public interface ExamMapper {

	List<TestPaper> findAllTestPaper();

	List<QuestionBankVo> findAllCodingQuestion(Integer id);

	// 查询所有判断题
	List<QuestionBankVo> findAllJudgmentQuestion(Integer id);

	//用户成绩是否存在
	Score findIfExistenceScore(Score score);

	// 查询所有选择题
	List<QuestionBankVo> findAllChoiceQuestion(Integer id);

	// 查询当前用户当前时间
	Times findExamTimes(Times times);

	// 查询所有用户时间
	List<Times> findAllExamTimes();

	// 添加当前用户当前时间当前试卷
	Integer addExamTimes(Times times);

	// 更新当前数据时间-1分钟
	Integer updateExamTimes(Times times);

}
