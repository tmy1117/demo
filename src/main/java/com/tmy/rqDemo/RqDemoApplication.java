package com.tmy.rqDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tmy.rqDemo.repository")
@SpringBootApplication
public class RqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RqDemoApplication.class, args);
    }

}
