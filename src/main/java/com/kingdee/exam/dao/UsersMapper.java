package com.kingdee.exam.dao;

import com.kingdee.exam.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //查询所有用户
    //2.4查询用户数据Dao（数据持久层） 写SQL 的接口
    List<User> findUserInfo();

    public User getUserByUserId(@Param("userId") long userId);
}