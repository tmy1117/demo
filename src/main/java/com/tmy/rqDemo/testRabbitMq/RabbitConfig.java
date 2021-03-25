package com.tmy.rqDemo.testRabbitMq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: muyang.tian
 * @Date: 2021-03-24 20:12
 */
@Configuration
public class RabbitConfig {

    private final static String QUEUE_EMAIL = "queue_email";
    private final static String QUEUE_SMS ="queue_sms";
    public final static String EXCHANGE_NAME = "topic.exchange";
    private final static String ROUTINGKEY_EMAIL = "topic.#.email.#";
    private final static String ROUTINGKEY_SMS = "topic.#.sms.#";

    @Bean(EXCHANGE_NAME)
    public Exchange exchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean(QUEUE_EMAIL)
    public Queue queueEmail(){
        return new Queue(QUEUE_EMAIL);
    }

    @Bean(QUEUE_SMS)
    public Queue queueSms(){
        return new Queue(QUEUE_SMS);
    }

    @Bean
    public Binding bindingEmail(@Qualifier(QUEUE_EMAIL)Queue queue,
                                @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
    }

    @Bean
    public Binding bindingSms(@Qualifier(QUEUE_SMS) Queue queue,
                              @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }
}
