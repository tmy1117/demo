package com.tmy.rqdemo.controller;

import com.alibaba.fastjson.JSON;
import com.tmy.rqdemo.entity.User;
import com.tmy.rqdemo.repository.UserRepository;
import com.tmy.rqdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author: muyang.tian
 * @Date: 2021-03-19 15:06
 * 登录
 */
@RequestMapping("/")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String Login(@RequestParam("name") String name,@RequestParam("password") String password){
        User user = userService.Login(name,password);
        return JSON.toJSONString(user);
    }

    @GetMapping("/Hello_word")
    public String HelloWord(){
        return JSON.toJSONString(userRepository.selectList(null));
    }
}
