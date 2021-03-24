package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 17:52
 */
public class DirectRecv {

    private final static String EXCHANGE_NAME = "test_direct";
    private final static String QUEUE_NAME = "direct_exchange_queue_sms";

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionUtil.GetConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"sms");
            DefaultConsumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                    String msg = new String(body);
                    System.out.println("[短信服务] :"+msg);
                }
            };
            channel.basicConsume(QUEUE_NAME,true,consumer);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
