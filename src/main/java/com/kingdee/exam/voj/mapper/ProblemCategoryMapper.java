package com.kingdee.exam.voj.mapper;

import com.kingdee.exam.voj.model.ProblemCategory;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface ProblemCategoryMapper {
	/**
	 * 获取全部的试题分类.
	 * @return 包含全部试题分类的列表
	 */
	List<ProblemCategory> getProblemCategories();
	
	/**
	 * 通过试题分类的唯一标识符获取试题分类对象.
	 * @param problemCategoryId - 试题分类的唯一标识符
	 * @return 预期的试题分类对象或空引用
	 */
	ProblemCategory getProblemCategoryUsingCategoryId(int problemCategoryId);

	/**
	 * 通过试题分类的别名获取试题分类对象.
	 * @param problemCategorySlug - 试题分类的别名
	 * @return 预期的试题分类对象或空引用
	 */
	ProblemCategory getProblemCategoryUsingCategorySlug(String problemCategorySlug);

	/**
	 * 创建试题及试题分类的关系.
	 * @param problemId - 试题的唯一标识符
	 * @param problemCategory - 试题分类对象
	 */
	int createProblemCategoryRelationship(@Param(value = "problemId") long problemId, @Param(value = "problemCategory") ProblemCategory problemCategory);

	/**
	 * 删除试题的全部分类关系.
	 * @param problemId - 试题的唯一标识符
	 */
	int deleteProblemCategoryRelationship(long problemId);
}
