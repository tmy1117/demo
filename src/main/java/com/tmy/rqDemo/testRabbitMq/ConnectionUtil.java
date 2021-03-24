package com.tmy.rqDemo.testRabbitMq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 10:03
 */
class ConnectionUtil {

    static Connection GetConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.103.200.57");
        factory.setUsername("admin");
        factory.setPassword("123456");

        return factory.newConnection();
    }

}
