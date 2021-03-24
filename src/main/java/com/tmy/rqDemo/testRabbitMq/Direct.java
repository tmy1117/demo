package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 17:44
 */
public class Direct {

    private final static String EXCHANGE_NAME = "test_direct";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.GetConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            String massage = "注册成功！请短信回复[T]退订";
            channel.basicPublish(EXCHANGE_NAME,"email",null,massage.getBytes());
            System.out.println("[sent] :"+massage);
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
