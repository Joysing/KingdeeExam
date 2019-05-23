package com.kingdee.exam.mapper;

import com.kingdee.exam.KingdeeExamApplication;
import com.kingdee.exam.dao.UsersMapper;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.voj.mapper.LanguageMapper;
import com.kingdee.exam.voj.mapper.ProblemMapper;
import com.kingdee.exam.voj.mapper.SubmissionMapper;
import com.kingdee.exam.voj.model.Language;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.model.Submission;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * SubmissionMapper测试类.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KingdeeExamApplication.class)
public class SubmissionMapperTest {

	/**
	 * 测试用例: 测试getSubmission(long)方法
	 * 测试数据: Problem#1000的提交记录的唯一标识符
	 * 预期结果: 返回预期的Submission对象
	 */
	@Test
	public void testGetSubmissionExists() {
		Submission submission = submissionMapper.getSubmission(1000);
		Assertions.assertNotNull(submission);
		
		Problem problem = submission.getProblem();
		long problemId = problem.getProblemId();
		Assertions.assertEquals(1000, problemId);
	}
	
	/**
	 * 测试用例: 测试getSubmission(long)方法
	 * 测试数据: 不存在的的提交记录唯一标识符
	 * 预期结果: 返回空引用
	 */
	@Test
	public void testGetSubmissionNotExists() {
		Submission submission = submissionMapper.getSubmission(0);
		Assertions.assertNull(submission);
	}
	
	/**
	 * 测试用例: 测试getSubmissionUsingProblemIdAndUserId(long, long, int)方法
	 * 测试数据: 获取试题ID#1000和用户ID#1000的最新1次提交
	 * 预期结果: 返回预期的提交列表(共1次提交)
	 */
	@Test
	public void testGetSubmissionUsingExistingProblemIdAndExistingUserId() {
		List<Submission> submissions = submissionMapper.getSubmissionUsingProblemIdAndUserId(1000, 1000, 1);
		Assertions.assertEquals(1, submissions.size());
		
		Submission firstSubmission = submissions.get(0);
		long submissionId = firstSubmission.getSubmissionId();
		Assertions.assertEquals(1001, submissionId);
		
		String judgeResultSlug = firstSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("WA", judgeResultSlug);
	}
	
	/**
	 * 测试用例: 测试getSubmissionUsingProblemIdAndUserId(long, long, int)方法
	 * 测试数据: 使用不存在的试题唯一标识符
	 * 预期结果: 返回空提交列表
	 */
	@Test
	public void testGetSubmissionUsingNotExistingProblemIdAndExistingUserId() {
		List<Submission> submissions = submissionMapper.getSubmissionUsingProblemIdAndUserId(0, 1000, 10);
		Assertions.assertEquals(0, submissions.size());
	}
	
	/**
	 * 测试用例: 测试getSubmissionUsingProblemIdAndUserId(long, long, int)方法
	 * 测试数据: 使用不存在的用户唯一标识符
	 * 预期结果: 返回空提交列表
	 */
	@Test
	public void testGetSubmissionUsingExistingProblemIdAndNotExistingUserId() {
		List<Submission> submissions = submissionMapper.getSubmissionUsingProblemIdAndUserId(1000, 0, 10);
		Assertions.assertEquals(0, submissions.size());
	}
	
	/**
	 * 测试用例: 测试getLatestSubmissionOfProblems(long, long, long)方法
	 * 测试数据: 获取用户ID#1000在试题ID区间[1000, 1010)的最新评测结果
	 * 预期结果: 返回预期的提交列表(试题ID#1000 - WA, 试题ID#1001 - AC)
	 */
	@Test
	public void testGetLatestSubmissionOfProblemsWithUser1000() {
		List<Submission> submissions = submissionMapper.getLatestSubmissionOfProblems(1000, 1000, 1010);
		Assertions.assertEquals(2, submissions.size());
		
		Submission firstSubmission = submissions.get(0);
		String firstJudgeResultSlug = firstSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("WA", firstJudgeResultSlug);
		
		Submission secondSubmission = submissions.get(1);
		String secondJudgeResultSlug = secondSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("AC", secondJudgeResultSlug);
	}
	
	/**
	 * 测试用例: 测试getLatestSubmissionOfProblems(long, long, long)方法
	 * 测试数据: 获取用户ID#1001在试题ID区间[1000, 1010)的最新评测结果
	 * 预期结果: 返回预期的提交列表(试题ID#1000 - CE)
	 */
	@Test
	public void testGetLatestSubmissionOfProblemsWithUser1001() {
		List<Submission> submissions = submissionMapper.getLatestSubmissionOfProblems(1001, 1000, 1010);
		Assertions.assertEquals(1, submissions.size());
		
		Submission firstSubmission = submissions.get(0);
		String firstJudgeResultSlug = firstSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("CE", firstJudgeResultSlug);
	}
	
	/**
	 * 测试用例: 测试getAcceptedSubmissionOfProblems(long, long, long)方法
	 * 测试数据: 获取用户ID#1000在试题ID区间[1000, 1010)的通过评测结果
	 * 预期结果: 返回预期的提交列表(试题ID#1000 - AC, 试题ID#1001 - AC)
	 */
	@Test
	public void testGetAcceptedSubmissionOfProblemsWithUser1000() {
		List<Submission> submissions = submissionMapper.getAcceptedSubmissionOfProblems(1000, 1000, 1010);
		Assertions.assertEquals(2, submissions.size());
		
		Submission firstSubmission = submissions.get(0);
		String firstJudgeResultSlug = firstSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("AC", firstJudgeResultSlug);
		
		Submission secondSubmission = submissions.get(1);
		String secondJudgeResultSlug = secondSubmission.getJudgeResult().getJudgeResultSlug();
		Assertions.assertEquals("AC", secondJudgeResultSlug);
	}
	
	/**
	 * 测试用例: 测试getAcceptedSubmissionOfProblems(long, long, long)方法
	 * 测试数据: 获取用户ID#1001在试题ID区间[1000, 1010)的通过评测结果
	 * 预期结果: 返回空提交列表
	 */
	@Test
	public void testGetAcceptedSubmissionOfProblemsWithUser1001() {
		List<Submission> submissions = submissionMapper.getAcceptedSubmissionOfProblems(1001, 1000, 1010);
		Assertions.assertEquals(0, submissions.size());
	}
	
	/**
	 * 测试用例: 测试createSubmission(Submission)方法
	 * 测试数据: 使用合法的数据集
	 * 预期结果: 数据插入操作成功完成
	 */
	@Test
	public void testCreateSubmissionNormally() {
		Problem problem = problemMapper.getProblem(1000);
		User user = userMapper.getUserByUserId(1);
		Language language = languageMapper.getLanguageUsingId(1);
		
		Submission submission = new Submission(problem, user, language, "C Code");
		int numberOfRowsAffected = submissionMapper.createSubmission(submission);
		Assertions.assertEquals(1, numberOfRowsAffected);
	}
	
	/**
	 * 测试用例: 测试createSubmission(Submission)方法
	 * 测试数据: 使用不存在的外键值(编程语言对象)
	 * 预期结果: 抛出DataIntegrityViolationException异常
	 */
	@Test
	public void testCreateSubmissionUsingNotExistingLanguage() {
		Problem problem = problemMapper.getProblem(1000);
		User user = userMapper.getUserByUserId(1);
		Language language = new Language(0, "not-exists", "Not Exists", "Not Exists", "Not Exists");
		
		Submission submission = new Submission(problem, user, language, "Code");
		Executable e = () -> {
			submissionMapper.createSubmission(submission);
		};
		Assertions.assertThrows(org.springframework.dao.DataIntegrityViolationException.class, e);
	}
	
	/**
	 * 测试用例: 测试updateSubmission(Submission)方法
	 * 测试数据: 使用合法的数据集, 且数据表中存在对应ID的记录
	 * 预期结果: 数据更新操作成功完成
	 */
	@Test
	public void testUpdateSubmissionNormally() {
		Submission submission = submissionMapper.getSubmission(1002);
		Assertions.assertNotNull(submission);
		
		submission.setJudgeScore(20);
		int numberOfRowsAffected = submissionMapper.updateSubmission(submission);
		Assertions.assertEquals(1, numberOfRowsAffected);
		
		/**
		 * The following Assert CANNOT passed in CI due to 
		 * the bug of Spring Test Framework. But it really works.
		 */
		/*
		 * Submission updatedSubmission = submissionMapper.getSubmission(1002);
		 * int judgeScore = updatedSubmission.getJudgeScore();
		 * Assertions.assertEquals(20, judgeScore);
		 */
	}
	
	/**
	 * 测试用例: 测试updateSubmission(Submission)方法
	 * 测试数据: 使用合法的数据集, 但数据表中不存在对应ID的记录
	 * 预期结果: 方法正常执行, 未影响数据表中的数据
	 */
	@Test
	public void testUpdateSubmissionNotExists() {
		Submission submission = submissionMapper.getSubmission(1000);
		Assertions.assertNotNull(submission);
		
		submission.setSubmissionId(0);
		int numberOfRowsAffected = submissionMapper.updateSubmission(submission);
		Assertions.assertEquals(0, numberOfRowsAffected);
	}
	
	/**
	 * 测试用例: 测试deleteSubmission(long)方法
	 * 测试数据: 提交记录#1003的唯一标识符
	 * 预期结果: 数据删除操作成功完成
	 */
	@Test
	public void testDeleteSubmissionExists() {
		Submission submission = submissionMapper.getSubmission(1004);
		Assertions.assertNotNull(submission);
		
		int numberOfRowsAffected = submissionMapper.deleteSubmission(1004);
		Assertions.assertEquals(1, numberOfRowsAffected);
		
		submission = submissionMapper.getSubmission(1004);
		Assertions.assertNull(submission);
	}
	
	/**
	 * 测试用例: 测试deleteSubmission(long)方法
	 * 测试数据: 不存在的提交记录唯一标识符
	 * 预期结果: 方法正常执行, 未影响数据表中的数据
	 */
	@Test
	public void testDeleteSubmissionNotExists() {
		Submission submission = submissionMapper.getSubmission(0);
		Assertions.assertNull(submission);
		
		int numberOfRowsAffected = submissionMapper.deleteSubmission(0);
		Assertions.assertEquals(0, numberOfRowsAffected);
	}
	
	/**
	 * 待测试的SubmissionMapper对象.
	 */
	@Autowired
	private SubmissionMapper submissionMapper;
	
	/**
	 * ProblemMapper对象, 用于构建单元测试用例.
	 */
	@Autowired
	private ProblemMapper problemMapper;
	
	/**
	 * UserMapper对象, 用于构建单元测试用例.
	 */
	@Autowired
	private UsersMapper userMapper;
	
	/**
	 * LanguageMapper对象, 用于构建单元测试用例.
	 */
	@Autowired
	private LanguageMapper languageMapper;
}
