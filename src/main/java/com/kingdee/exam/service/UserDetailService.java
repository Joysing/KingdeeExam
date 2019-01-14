package com.kingdee.exam.service;

import com.kingdee.exam.dao.UserRepository;
import com.kingdee.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserDetailService(UserRepository userRepository){
        this.repository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("找不"+username+"的信息！");//抛出异常，根据配置跳到登录失败页面

        return user;
    }
}