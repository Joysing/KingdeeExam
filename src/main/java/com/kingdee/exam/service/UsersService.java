package com.kingdee.exam.service;


import com.kingdee.exam.entity.User;

import java.util.List;

public interface UsersService {
    //查询所有用户
    
	//2.1查询用户数据 接口
    List<User> findUserInfo();
    
    //删除用户信息
   int deleteByPrimaryKey(String userId);

    //添加账号
    boolean addUser(User user);

    //修改账号
    boolean updateUser(User user);

    User getUserByUsername(String username);
}
