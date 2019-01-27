package com.kingdee.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingdee.exam.dao.QuestionBankMapper;
import com.kingdee.exam.entity.Options;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.QuestionBankService;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 题库业务类
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	private final QuestionBankMapper questionBankMapper;
    private final ProblemService problemService;
    @Autowired
    public QuestionBankServiceImpl(QuestionBankMapper questionBankMapper, ProblemService problemService) {
        this.questionBankMapper = questionBankMapper;
        this.problemService = problemService;
    }

    /**
	 * 查询所有试题
	 */
	@Override
	public PageInfo<QuestionBankVo> findAllQuestionBank(PageInfo<QuestionBankVo> pageInfo) {
		
		PageHelper.startPage(pageInfo.getPageNum()==0?1:pageInfo.getPageNum(), 40);
		
		List<QuestionBankVo> AllQuestionBank = questionBankMapper.findAllQuestionBank();

        return new PageInfo<>(AllQuestionBank);
	}

	@Override
	public boolean addQuestionBank(QuestionBankVo questionBankVo) {
		questionBankVo.setState(1);//设置题目有效
		int questionBankState = questionBankMapper.addQuestionBank(questionBankVo);

		switch (questionBankVo.getTestsType()){
            case 0://判断题
                return questionBankState >= 1;
            case 1://选择题
                for (Options op : questionBankVo.getOptions()) {
                    op.setQuestionBankId(questionBankVo.getQuestionBankId());
                }
                int optionsState = questionBankMapper.addOptions(questionBankVo.getOptions());
                return questionBankState >= 1 && optionsState >= 1;
            case 2://编程题
                Problem problem=questionBankVo.getCodingProblem();
                if ( problem.getTimeLimit()<=0 ) {
                    problem.setTimeLimit(-1);
                }
                if ( problem.getMemoryLimit()<=0 ) {
                    problem.setMemoryLimit(-1);
                }

                Map<String, Object> result = problemService.createProblem(problem.getProblemName(),questionBankVo.getQuestionBankId(),
                        problem.getTimeLimit(), problem.getMemoryLimit(), problem.getDescription(), problem.getHint(),
                        problem.getInputFormat(), problem.getOutputFormat(), problem.getSampleInput(),
                        problem.getSampleOutput(), problem.getTestCases(), "[]",
                        true);

                return (boolean) result.get("isSuccessful");
            default:
                return false;
        }
	}

	/**
	 * 删除试题
	 */
	@Override
	public boolean deleteQuestionBank(String questionBankId) {
		
		int updateQuestionBankState = questionBankMapper.updateQuestionBankState(questionBankId);
        return updateQuestionBankState >= 1;

    }

	/**
	 * 更新题目
	 */
	@Override
	public boolean updateQuestionBank(QuestionBankVo questionBankVo) {
		
		Integer testsType = questionBankVo.getTestsType();
		int updateQuestionBank = questionBankMapper.updateQuestionBank(questionBankVo);
		if (updateQuestionBank >= 1) {
			questionBankMapper.deleteQuestionBankOptions(questionBankVo.getQuestionBankId().toString());
			if (testsType == 1) {
				for (Options op : questionBankVo.getOptions()) {
					op.setQuestionBankId(questionBankVo.getQuestionBankId());
				}
				questionBankMapper.addOptions(questionBankVo.getOptions());
			}
			return true;
		}
		
		return false;
	}

}
