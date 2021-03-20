package com.tmy.rqdemo.service.impl;

import com.tmy.rqdemo.entity.User;
import com.tmy.rqdemo.repository.UserRepository;
import com.tmy.rqdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: muyang.tian
 * @Date: 2021-03-20 14:00
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userMapper;

    @Override
    public User Login(String name, String password) {
        User user = userMapper.findUserByName(name);
        return user;
    }
}
