package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 17:07
 * 广播类型的消息
 */
public class Fanout {

    private final static String EXCHANGE_NAME = "test_fanout";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.GetConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            String massage = "注册成功!";
            channel.basicPublish(EXCHANGE_NAME,"",null,massage.getBytes());
            System.out.println("[生产者] :"+massage);
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
