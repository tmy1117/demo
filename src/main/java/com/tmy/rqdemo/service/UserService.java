package com.tmy.rqdemo.service;

import com.tmy.rqdemo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author: muyang.tian
 * @Date: 2021-03-19 15:36
 */
@Service
public interface UserService {

    User Login(String name,String password);

}
