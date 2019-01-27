package com.kingdee.exam.service;

import com.kingdee.exam.entity.User;

/**
 * 业务管业务类
 *
 */
public interface AdminService {

	//查询用户名-密码--接口
	public User findByUser(User user);

}
