package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.TestPaperTestsMapper;
import com.kingdee.exam.entity.TestPaperTests;
import com.kingdee.exam.entity.TestPaperTestsList;
import com.kingdee.exam.entity.vo.TestPaperTestsVo;
import com.kingdee.exam.service.TestPaperTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestPaperTestServiceImpl implements TestPaperTestService {
	
	@Autowired
	private TestPaperTestsMapper testPaperTestsMapper;

	@Override
	public List<TestPaperTestsVo> findSelectTestPaperQuesion(int testpaperId) {
		// TODO Auto-generated method stub
		return testPaperTestsMapper.findSelectTestPaperQuesion(testpaperId);
	}

	@Override
	public int deleteTestPaperTestById(int testpaperId) {
		// TODO Auto-generated method stub
		return testPaperTestsMapper.deleteTestPaperTestById(testpaperId);
	}

	@Override
	public int addTestPaperQuestion(TestPaperTestsList testPaperTestsList) {
		
		List<TestPaperTests> testPaperTests = new ArrayList<TestPaperTests>();
		
		for (Integer id : testPaperTestsList.getQuestionBankId()) {
			TestPaperTests temp = new TestPaperTests();
			temp.setQuestionBankId(id);
			temp.setTestpaperId(testPaperTestsList.getTestpaperId());
			testPaperTests.add(temp);
		}
		
		return testPaperTestsMapper.addTestPaperQuestion(testPaperTests);
	}

}
