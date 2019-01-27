package com.kingdee.exam.voj.mapper;

import com.kingdee.exam.voj.model.Option;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Opton Data Access Object.
 */
@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface OptionMapper {
	/**
	 * 获取全部系统选项.
	 * @return 一个包含全部系统选项的列表
	 */
	List<Option> getOptions();
	
	/**
	 * 获取自动加载的系统选项.
	 * @return 一个包含自动加载系统选项的列表
	 */
	List<Option> getAutoloadOptions();
	
	/**
	 * 根据系统选项的名称获取选项的值.
	 * @param optionName - 系统选项的名称 
	 * @return 对应的Option对象
	 */
	Option getOption(@Param("optionName") String optionName);
	
	/**
	 * 更新系统选项.
	 * @param option - 系统选项对象
	 */
	int updateOption(Option option);
}
