package com.kingdee.exam.dao;

import com.kingdee.exam.entity.User;

public interface AdminMapper {
	
	//查询用户 id 密码
	public User findByUser(User users);
	
}
