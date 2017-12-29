package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * @Author: yangguiyun
 * @Date: 2017/11/3 9:33
 * @Description:
 */

@Component
@RabbitListener(queues = "hello")
public class AmqpListener {
    @RabbitHandler
    public void listen(UserParam message) {
        System.out.println(message);
    }
}
