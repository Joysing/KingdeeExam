package com.kingdee.exam.voj.service;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.voj.mapper.LanguageMapper;
import com.kingdee.exam.voj.mapper.ProblemMapper;
import com.kingdee.exam.voj.mapper.SubmissionMapper;
import com.kingdee.exam.voj.messenger.MessageSender;
import com.kingdee.exam.voj.model.Language;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 提交类(Submission)的业务逻辑层.
 */
@Service
@Transactional
public class SubmissionService {
    @Autowired
    public SubmissionService(SubmissionMapper submissionMapper, ProblemMapper problemMapper, LanguageMapper languageMapper, MessageSender messageSender) {
        this.submissionMapper = submissionMapper;
        this.problemMapper = problemMapper;
        this.languageMapper = languageMapper;
        this.messageSender = messageSender;
    }

	/**
	 * 根据评测记录的唯一标识符获取评测记录对象.
	 * @param submissionId - 评测记录的唯一标识符
	 * @return 评测记录对象
	 */
	public Submission getSubmission(long submissionId) {
		return submissionMapper.getSubmission(submissionId);
	}

    /**
	 * 创建提交记录, 并将评测任务加入消息队列.
	 * @param user - 已登录的用户对象
	 * @param problemId - 试题的唯一标识符
	 * @param languageSlug - 编程语言的别名
	 * @param code - 代码
	 * @return 一个包含提交记录创建结果的Map<String, Object>对象, 并包含创建的提交记录的唯一标识符.
	 */
	public Map<String, Object> createSubmission(User user, long problemId,
												String languageSlug, String code) {
		Problem problem = problemMapper.getProblem(problemId);
		Language language = languageMapper.getLanguageUsingSlug(languageSlug);
		
		Submission submission = new Submission(problem, user, language, code);
		
		Map<String, Object> result = (Map<String, Object>) getSubmissionCreationResult(submission);
		boolean isSuccessful = (Boolean)result.get("isSuccessful");
		if ( isSuccessful ) {
			submissionMapper.createSubmission(submission);
			
			long submissionId = submission.getSubmissionId();
			createSubmissionTask(submissionId);
			result.put("submissionId", submissionId);
		}
		return result;
	}
	
	/**
	 * 验证提交记录数据.
	 * @param submission - 待创建的提交记录对象
	 * @return 一个包含提交记录的验证结果的Map<String, Boolean>对象
	 */
	private Map<String, ?> getSubmissionCreationResult(Submission submission) {
		Map<String, Boolean> result = new HashMap<>(5, 1);
		String code = submission.getCode();
		result.put("isUserLogined", submission.getUser() != null);
		result.put("isProblemExists", submission.getProblem() != null);
		result.put("isLanguageExists", submission.getLanguage() != null);
		result.put("isCodeEmpty", code == null || code.length() == 0);

		boolean isSuccessful = result.get("isUserLogined")	&&  result.get("isProblemExists") &&
							   result.get("isLanguageExists") && !result.get("isCodeEmpty");
		result.put("isSuccessful", isSuccessful);
		return result;
	}
	
	/**
	 * 创建评测任务, 将提交的信息提交至消息队列.
	 * @param submissionId - 提交记录的唯一标识符
	 */
	public void createSubmissionTask(long submissionId) {
		Map<String, Object> mapMessage = new HashMap<>();
		mapMessage.put("event", "SubmissionCreated");
		mapMessage.put("submissionId", submissionId);
		
		messageSender.sendMessage(mapMessage);
	}

    /**
	 * 自动注入的SubmissionMapper对象.
	 */
	private final SubmissionMapper submissionMapper;
	
	/**
	 * 自动注入的ProblemMapper对象.
	 */
	private final ProblemMapper problemMapper;
	
	/**
	 * 自动注入的LanguageMapper对象.
	 */
	private final LanguageMapper languageMapper;
	
	/**
	 * 自动注入的MessageSender对象.
	 */
	private final MessageSender messageSender;
}
