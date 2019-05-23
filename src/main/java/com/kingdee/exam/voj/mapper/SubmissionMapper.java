package com.kingdee.exam.voj.mapper;

import com.kingdee.exam.voj.model.Submission;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface SubmissionMapper {

    /**
	 * 通过评测记录唯一标识符获取试题对象.
	 * @param submissionId - 评测记录的唯一标识符
	 * @return 一个评测记录对象
	 */
	Submission getSubmission(@Param("submissionId") long submissionId);


    /**
	 * 获取某个用户对某个试题的提交记录.
	 * @param problemId - 试题的唯一标识符
	 * @param uid - 用户的唯一标识符
	 * @param limit - 每次加载评测记录的数量
	 * @return 某个用户对某个试题的提交记录
	 */
	List<Submission> getSubmissionUsingProblemIdAndUserId(@Param("problemId") long problemId, @Param("uid") long uid, @Param("limit") int limit);
	
	/**
	 * 获取某个用户在某个试题ID区间段内的最新的评测结果.
	 * @param uid - 用户的唯一标识符
	 * @param problemIdLowerBound - 试题ID区间的下界
	 * @param problemIdUpperBound - 试题ID区间的上界
	 * @return 某个试题ID区间段内的最新的评测结果
	 */
	List<Submission> getLatestSubmissionOfProblems(@Param("uid") long uid, @Param("problemIdLowerBound") long problemIdLowerBound, @Param("problemIdUpperBound") long problemIdUpperBound);
	
	/**
	 * 获取某个用户在某个试题ID区间段内的通过的评测结果.
	 * @param uid - 用户的唯一标识符
	 * @param problemIdLowerBound - 试题ID区间的下界
	 * @param problemIdUpperBound - 试题ID区间的上界
	 * @return 某个试题ID区间段内的通过的评测结果
	 */
	List<Submission> getAcceptedSubmissionOfProblems(@Param("uid") long uid, @Param("problemIdLowerBound") long problemIdLowerBound, @Param("problemIdUpperBound") long problemIdUpperBound);

    /**
	 * 创建提交记录.
	 * @param submission - 待创建的提交记录对象
	 */
	int createSubmission(Submission submission);
	
	/**
	 * 更新提交记录.
	 * @param submission - 待更新的提交记录对象
	 */
	int updateSubmission(Submission submission);
	
	/**
	 * 通过提交记录的唯一标识符删除提交记录.
	 * @param submissionId - 提交记录的唯一标识符
	 */
	int deleteSubmission(@Param("submissionId") long submissionId);
}
