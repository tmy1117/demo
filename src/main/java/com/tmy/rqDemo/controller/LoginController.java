package com.tmy.rqDemo.controller;

import com.alibaba.fastjson.JSON;
import com.tmy.rqDemo.entity.User;
import com.tmy.rqDemo.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * @author: muyang.tian
 * @Date: 2021-03-19 15:06
 * 登录
 */
@RestController
public class LoginController {

    @Resource
    private UserService userService;


    @PostMapping("")
    public String Login(@RequestParam String name,@RequestParam String password){
        User users = userService.Login(name,password);
        return JSON.toJSONString(users);
    }
}
