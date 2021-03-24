package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 09:40
 * 工作队列的消息第二位接受者
 */
public class SecondRecv {

    private final static String QUEUE_NAME = "HELLO WORLD";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.GetConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("[*] Waiting for massage. To exit press CTRL+C");
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String massage = new String(body, StandardCharsets.UTF_8);
                System.out.println("第二位消费者:'"+massage+"'!");
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,false,consumer);
    }
}
