package com.kingdee.exam.service.impl;

import com.kingdee.exam.dao.UsersMapper;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;

	//2.2查询用户数据 实现
	@Override
	public List<User> findUserInfo() {
		
		//2.3查询用户数据Dao（数据持久层）
		List<User> findUserInfo = usersMapper.findUserInfo();
		
		return findUserInfo;
	}

	@Override
	public int deleteByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		return usersMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public boolean addUser(User user) {
		int userState = usersMapper.insert(user);
        return userState >= 1;
    }

}
