package com.kingdee.exam.mapper;

import com.kingdee.exam.KingdeeExamApplication;
import com.kingdee.exam.voj.mapper.JudgeResultMapper;
import com.kingdee.exam.voj.model.JudgeResult;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * JudgeResultMapper测试类.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KingdeeExamApplication.class)
public class JudgeResultMapperTest {
	/**
	 * 测试用例: 测试getJudgeResultUsingId(int)方法
	 * 测试数据: Accept评测结果(JudgeResult)的评测结果组唯一标识符
	 * 预期结果: 返回评测结果(JudgeResult)的评测结果组对象
	 */
	@Test
	public void testGetJudgeResultUsingIdExists() {
		JudgeResult judgeResult = judgeResultMapper.getJudgeResultUsingId(2);
		Assertions.assertNotNull(judgeResult);
		
		String judgeResultSlug = judgeResult.getJudgeResultSlug();
		Assertions.assertEquals("AC", judgeResultSlug);
	}
	
	/**
	 * 测试用例: 测试getJudgeResultUsingId(int)方法
	 * 测试数据: 不存在的评测结果组唯一标识符
	 * 预期结果: 返回空引用
	 */
	@Test
	public void testGetJudgeResultUsingIdNotExists() {
		JudgeResult judgeResult = judgeResultMapper.getJudgeResultUsingId(0);
		Assertions.assertNull(judgeResult);
	}
	
	/**
	 * 测试用例: 测试getJudgeResultUsingSlug(String)方法
	 * 测试数据: 普通评测结果(JudgeResult)的评测结果组别名
	 * 预期结果: 返回评测结果(JudgeResult)的评测结果组对象
	 */
	@Test
	public void testGetJudgeResultUsingSlugExists() {
		JudgeResult judgeResult = judgeResultMapper.getJudgeResultUsingSlug("AC");
		Assertions.assertNotNull(judgeResult);
		
		int judgeResultId = judgeResult.getJudgeResultId();
		Assertions.assertEquals(2, judgeResultId);
	}
	
	/**
	 * 测试用例: 测试getJudgeResultUsingSlug(String)方法
	 * 测试数据: 不存在的评测结果组别名
	 * 预期结果: 返回空引用
	 */
	@Test
	public void testGetJudgeResultUsingSlugNotExists() {
		JudgeResult judgeResult = judgeResultMapper.getJudgeResultUsingSlug("Not-Exists");
		Assertions.assertNull(judgeResult);
	}
	
	/**
	 * 待测试的JudgeResultMapper对象.
	 */
	@Autowired
	private JudgeResultMapper judgeResultMapper;
}
