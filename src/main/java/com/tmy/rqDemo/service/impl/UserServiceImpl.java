package com.tmy.rqDemo.service.impl;

import com.tmy.rqDemo.entity.User;
import com.tmy.rqDemo.repository.UserRepository;
import com.tmy.rqDemo.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: muyang.tian
 * @Date: 2021-03-20 14:00
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userMapper;

    @Override
    public User Login(String name, String password) {
        return userMapper.findUserByName(name);
    }
}
