package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.AdminMapper;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	//查询用户名-密码--接口
	@Override
	public User findByUser(User users) {
		
		User user = adminMapper.findByUser(users);
		
		return user;
	}

}
