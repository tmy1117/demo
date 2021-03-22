package com.tmy.rqDemo;

import com.alibaba.fastjson.JSON;
import com.tmy.rqDemo.entity.User;
import com.tmy.rqDemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class RqDemoApplicationTests {

    @Resource
    private UserRepository userRepository;
    @Test
    void testuser(){
        List<User> users = userRepository.selectList(null);
        System.out.println(JSON.toJSON(users));
    }

}
