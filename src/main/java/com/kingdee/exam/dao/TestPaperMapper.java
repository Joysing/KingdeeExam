package com.kingdee.exam.dao;


import com.kingdee.exam.entity.TestPaper;

import java.util.List;

public interface TestPaperMapper {
    int deleteByPrimaryKey(Integer testpaperId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(Integer testpaperId);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
    
    
    //查询所有试卷
    List<TestPaper> getAllTestPaper();
    //查询所有有效试卷
    List<TestPaper> findTestPaperInfo();

    //删除试卷
    int deleteTestPaper(int testpaperId);
    //更改试卷状态
    int updateTestPaperState(int testpaperId);
    //更改试卷开考状态
    int updateIsStart(TestPaper testPaper);
    //编辑试卷信息
    int updateTestPaperInfo(TestPaper testPaper);
    
}