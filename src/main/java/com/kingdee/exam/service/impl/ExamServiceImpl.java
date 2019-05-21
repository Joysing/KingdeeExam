package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.ExamMapper;
import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.Times;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.ExamService;
import com.kingdee.exam.util.AESEncryptor;
import com.kingdee.exam.util.HttpSessionParser;
import com.kingdee.exam.voj.model.Language;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.service.LanguageService;
import com.kingdee.exam.voj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return examMapper.findAllTestPaper();
	}

    @Override
    public TestPaper findTestPaperById(Integer testpaperId) {
        return examMapper.findTestPaperById(testpaperId);
    }

    // 查询题目
	@Override
	public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session) {

		/**
		 * 查询是否存在成绩
		 */
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(id));
		User users = HttpSessionParser.getCurrentUser(session);
		score.setUsersId(users.getUserId());
        //score.setUsersId(149000301);
		Score ifExistenceScore = examMapper.findIfExistenceScore(score);
		if (ifExistenceScore != null) {
			modelAndView.addObject("Fraction", ifExistenceScore.getFraction());
			modelAndView.setViewName("_exam/score");
			return;
		}
		int mouseLeave=3;
		//防止考生通过刷新页面更新鼠标移出次数
		if(session.getAttribute("mouseLeave")==null) {
            session.setAttribute("mouseLeave", mouseLeave);
        }else{
            mouseLeave=(int)session.getAttribute("mouseLeave");
        }
		session.setAttribute("testpaperId", id);
		// 判断题
		List<QuestionBankVo> findAllJudgmentQuestion = examMapper.findAllJudgmentQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllJudgmentQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
            session.setAttribute(questionBankVo.getQuestionBankId().toString()+"Type", "JudgmentQuestion");
		}
		// 选择题
		List<QuestionBankVo> findAllChoiceQuestion = examMapper.findAllChoiceQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllChoiceQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
            session.setAttribute(questionBankVo.getQuestionBankId().toString()+"Type", "ChoiceQuestion");
		}
		// 编程题
		Problem problem=new Problem();
		List<QuestionBankVo> findAllCodingQuestion = examMapper.findAllCodingQuestion(Integer.parseInt(id));
		for (QuestionBankVo questionBankVo : findAllCodingQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
			session.setAttribute(questionBankVo.getQuestionBankId().toString()+"Type", "CodingQuestion");
			problem = problemService.getProblemByQuestionBankId(questionBankVo.getQuestionBankId());
			if(problem.getHint()==null){
			    problem.setHint("");
            }
		}

        List<Language> languages = languageService.getAllLanguages();

		Times times = new Times();// 当前试卷-当前用户的试卷如果没时间设置时间
		times.setUserId(users.getUserId());
		//times.setUserId(149000301);
		times.setTestpaperId(Integer.parseInt(id));
		Times ifExamTimes = examMapper.findExamTimes(times);
		if (ifExamTimes == null) {
			times.setStartTime(new Date());
			examMapper.addExamTimes(times);
			session.setAttribute("ExamTime", "60:00");
		} else {
		    long seconds=60*60-(new Date().getTime()-ifExamTimes.getStartTime().getTime())/1000;
			session.setAttribute("ExamTime", seconds/60+":"+seconds%60);
		}

		modelAndView.addObject("testpaperName", findTestPaperById(Integer.parseInt(id)).getTestpaperName());
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
	public Object JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session) {
		double fraction = 0;
		for (QuestionBankVo questionBankVo : questionBankVos) {
			if (questionBankVo.getAnswer() != null) {
			    if(session.getAttribute(questionBankVo.getQuestionBankId().toString()+"Type").equals("CodingQuestion")){
                    questionBankVo.setTestsType(2);
			        String userAnswer=new AESEncryptor().decrypt(questionBankVo.getAnswer());
                    if (session.getAttribute(questionBankVo.getQuestionBankId().toString())
                            .equals(userAnswer)) {
                        fraction = fraction + 30;
                        questionBankVo.setIfCorrect(true);
                    } else {
                        questionBankVo.setIfCorrect(false);
                        questionBankVo
                                .setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
                    }
                }else {
                    if (session.getAttribute(questionBankVo.getQuestionBankId().toString())
                            .equals(questionBankVo.getAnswer())) {
                        fraction = fraction + 7;
                        questionBankVo.setIfCorrect(true);
                    } else {
                        questionBankVo.setIfCorrect(false);
                        questionBankVo
                                .setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
                    }
                }
			} else {
				questionBankVo.setIfCorrect(false);
				questionBankVo
						.setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
			}
		}
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(session.getAttribute("testpaperId").toString()));
		score.setUsersId(HttpSessionParser.getCurrentUser(session).getUserId());
		score.setFraction(fraction);
		int insertSelective = scoreMapper.insertSelective(score);
		if (insertSelective == 0) {// 设置分数是否成功
			return null;
		}
        Map<String,Object> map=new HashMap<>();
		map.put("questionBankVos",questionBankVos);
		map.put("score",fraction);
		return map;// 返回状态
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
			session.setAttribute("JudgmentQuestion", findAllJudgmentQuestion);
			session.setAttribute("ChoiceQuestion", findAllChoiceQuestion);
			// 存入时间
			// 初始化成绩
			return true;
		}

		return false;
	}

}
