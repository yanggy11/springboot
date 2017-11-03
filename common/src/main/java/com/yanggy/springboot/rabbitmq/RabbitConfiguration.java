package com.yanggy.springboot.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yangguiyun
 * @Date: 2017/11/3 10:51
 * @Description:
 */

@Configuration
public class RabbitConfiguration {
    @Autowired
    private ObjectMessageConverter objectMessageConverter;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(objectMessageConverter);

        return rabbitTemplate;
    }
}
