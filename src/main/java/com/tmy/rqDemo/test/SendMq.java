package com.tmy.rqDemo.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-23 20:25
 */
public class SendMq {

    private final static String QUEUE_NAME = "HELLO WORLD";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.GetConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.basicPublish("",QUEUE_NAME,null, "你说啥呢?".getBytes());
            System.out.println("[x] Sent:'"+QUEUE_NAME+"'");
            channel.close();
            connection.close();
        } catch (IOException e) {
            System.out.println("连接RabbitMQ异常,请检查配置");
        } catch (TimeoutException e) {
            System.out.println("连接RabbitMQ超时,请检查服务");
        }
    }
}
