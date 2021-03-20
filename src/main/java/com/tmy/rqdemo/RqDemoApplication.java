package com.tmy.rqdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tmy.rqdemo.repository")
@SpringBootApplication
public class RqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RqDemoApplication.class, args);
    }

}
