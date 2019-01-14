package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.ExamMapper;
import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.Times;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.ExamService;
import com.kingdee.exam.voj.model.Language;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.service.LanguageService;
import com.kingdee.exam.voj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private ScoreMapper scoreMapper;
	@Autowired
	private ProblemService problemService;
    @Autowired
    private LanguageService languageService;
	// 查询所有开始考试试卷到前端
	public List<TestPaper> findAllTestPaper() {

		List<TestPaper> allTestPaper = examMapper.findAllTestPaper();
		return allTestPaper;
	}

	// 查询题目
	@Override
	public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session) {

		/**
		 * 查询是否存在成绩
		 */
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(id));
//		User users = (User) session.getAttribute("myUser");
//		score.setUsersId(users.getUserId());
        score.setUsersId("149000301");
		Score ifExistenceScore = examMapper.findIfExistenceScore(score);
		if (ifExistenceScore != null) {
			modelAndView.addObject("Fraction", ifExistenceScore.getFraction());
			modelAndView.setViewName("_exam/score");
			return;
		}

		session.setAttribute("testpaperId", id);
		// 判断题
		List<QuestionBankVo> findAllJudgmentQuestion = examMapper.findAllJudgmentQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllJudgmentQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
		}
		// 选择题
		List<QuestionBankVo> findAllChoiceQuestion = examMapper.findAllChoiceQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllChoiceQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
		}
		// 编程题
		Problem problem=new Problem();
		List<QuestionBankVo> findAllCodingQuestion = examMapper.findAllCodingQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllCodingQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
			problem = problemService.getProblemByQuestionBankId(questionBankVo.getQuestionBankId());
		}

        List<Language> languages = languageService.getAllLanguages();

		Times times = new Times();// 当前试卷-当前用户的试卷如果没时间设置时间
//		times.setUserId(users.getUserId());
		times.setUserId("149000301");
		times.setTestpaperId(Integer.parseInt(id));
		Times ifExamTimes = examMapper.findExamTimes(times);
		if (ifExamTimes == null) {
			times.setDataMin(60.0);
			examMapper.addExamTimes(times);
			session.setAttribute("ExamTime", "60:00");
		} else {
			session.setAttribute("ExamTime", String.valueOf(ifExamTimes.getDataMin().intValue()));
		}

		modelAndView.addObject("JudgmentQuestion", findAllJudgmentQuestion);
		modelAndView.addObject("ChoiceQuestion", findAllChoiceQuestion);
		modelAndView.addObject("CodingQuestion", findAllCodingQuestion);
		modelAndView.addObject("problem", problem);
        modelAndView.addObject("languages", languages);
		modelAndView.setViewName("_exam/exam");
	}

	/**
	 * 判题方法
	 */
	@Override
	public List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session) {
		double fraction = 0;
		for (QuestionBankVo questionBankVo : questionBankVos) {
			if (questionBankVo.getAnswer() != null) {
				if (session.getAttribute(questionBankVo.getQuestionBankId().toString())
						.equals(questionBankVo.getAnswer())) {
					fraction = fraction + 10;
					questionBankVo.setIfCorrect(true);
				} else {
					questionBankVo.setIfCorrect(false);
					questionBankVo
							.setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
				}
			} else {
				questionBankVo.setIfCorrect(false);
				questionBankVo
						.setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
			}
		}
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(session.getAttribute("testpaperId").toString()));
		score.setUsersId(((User) session.getAttribute("myUser")).getUserId());
		score.setFraction(fraction);
		int insertSelective = scoreMapper.insertSelective(score);
		if (insertSelective == 0) {// 设置分数是否成功
			return null;
		}

		return questionBankVos;// 返回状态
	}

	/**
	 * 自动生成试卷
	 */
	@Override
	public boolean autoGenerate(HttpSession session, Integer id) {
		// 判断题
		List<QuestionBankVo> findAllJudgmentQuestion = examMapper.findAllJudgmentQuestion(id);

		// 选择题
		List<QuestionBankVo> findAllChoiceQuestion = examMapper.findAllChoiceQuestion(id);
		if (findAllChoiceQuestion.size() >= 5 && findAllChoiceQuestion.size() >= 5) {
			HashMap<String, List<QuestionBankVo>> hashMap = new HashMap<String, List<QuestionBankVo>>();
			hashMap.put("JudgmentQuestion", findAllJudgmentQuestion);
			hashMap.put("ChoiceQuestion", findAllChoiceQuestion);
			session.setAttribute("question", hashMap);
			session.setAttribute("XiaoBing", "XiaoBingBy");
			session.setAttribute("JudgmentQuestion", findAllJudgmentQuestion);
			session.setAttribute("ChoiceQuestion", findAllChoiceQuestion);
			// 存入时间
			// 初始化成绩
			return true;
		}

		return false;
	}

}
