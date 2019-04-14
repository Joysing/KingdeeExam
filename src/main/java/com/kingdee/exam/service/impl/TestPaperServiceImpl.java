package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.QuestionBankMapper;
import com.kingdee.exam.dao.TestPaperMapper;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPaperServiceImpl implements TestPaperService {
	private final TestPaperMapper testPaperMapper;
	private final QuestionBankMapper questionBankMapper; //题库

    @Autowired
    public TestPaperServiceImpl(TestPaperMapper testPaperMapper, QuestionBankMapper questionBankMapper) {
        this.testPaperMapper = testPaperMapper;
        this.questionBankMapper = questionBankMapper;
    }

    @Override
	public List<TestPaper> getAllTestPaper() {

		return testPaperMapper.getAllTestPaper();
	}
	@Override
	public List<TestPaper> findTestPaperInfo() {

		return testPaperMapper.findTestPaperInfo();
	}

	@Override
	public int deleteTestPaper(int testpaperId) {
		return testPaperMapper.deleteTestPaper(testpaperId);
	}
	@Override
	public int updateTestPaperState(int testpaperId) {
		return testPaperMapper.updateTestPaperState(testpaperId);
	}

	@Override
	public TestPaper selectByPrimaryKey(Integer testpaperId) {
		return testPaperMapper.selectByPrimaryKey(testpaperId);
	}

	@Override
	public int updateTestPaperInfo(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return testPaperMapper.updateTestPaperInfo(testPaper);
	}

	@Override
	public List<QuestionBankVo> findAllQuestionBank() {
		
		List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
		
		return findAllQuestionBank;
	}


}
