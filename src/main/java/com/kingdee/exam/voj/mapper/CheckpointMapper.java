package com.kingdee.exam.voj.mapper;

import com.kingdee.exam.voj.model.Checkpoint;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface CheckpointMapper {

	/**
	 * 创建测试点.
	 * @param checkpoint - 测试点
	 */
	int createCheckpoint(Checkpoint checkpoint);
	
	/**
	 * 删除某个试题的全部测试点.
	 * @param problemId - 试题的唯一标识符
	 */
	int deleteCheckpoint(long problemId);
}
