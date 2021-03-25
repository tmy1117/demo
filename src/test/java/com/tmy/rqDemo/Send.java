package com.tmy.rqDemo;

import com.tmy.rqDemo.testRabbitMq.RabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 20:25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Send {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsgByTopic(){

        for (int i = 1; i <= 5; i++) {

            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,"topic.sms.email",("用户注册成功 : "+i));
            System.out.println("发送成功"+i);
        }
    }

}
