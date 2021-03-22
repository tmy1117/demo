package com.tmy.rqDemo.service;

import com.tmy.rqDemo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author: muyang.tian
 * @Date: 2021-03-19 15:36
 */
@Service
public interface UserService {

    User Login(String name,String password);

}
