package com.tmy.rqdemo;

import com.alibaba.fastjson.JSON;
import com.tmy.rqdemo.entity.User;
import com.tmy.rqdemo.repository.UserRepository;
import com.tmy.rqdemo.service.UserService;
import com.tmy.rqdemo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class RqdemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserRepository userRepository;
    @Test
    void testuser(){
        List<User> users = userRepository.selectList(null);
        System.out.println(JSON.toJSON(users));
    }

}
