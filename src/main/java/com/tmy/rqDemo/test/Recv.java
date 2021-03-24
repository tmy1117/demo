package com.tmy.rqDemo.test;

import com.rabbitmq.client.*;
import java.nio.charset.StandardCharsets;
/**
 * @author: muyang.tian
 * @Date: 2021-03-24 09:40
 */
public class Recv {

    private final static String QUEUE_NAME = "HELLO WORLD";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.GetConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("[*] Waiting for massage. To exit press CTRL+C");
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                String massage = new String(body, StandardCharsets.UTF_8);
                System.out.println("msg:'"+massage+"'!");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
