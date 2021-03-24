package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 17:22
 * 广播类型消息的第二位接受者
 */
public class SecondFanoutRecv {

    private final static String EXCHANGE_NAME = "test_fanout";
    private final static String QUEUE_NAME = "fanout_exchange_queue_email";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.GetConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
            DefaultConsumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                    String msg = new String(body);
                    System.out.println("邮箱服务:"+msg);
                }
            };
            channel.basicConsume(QUEUE_NAME,true,consumer);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}
