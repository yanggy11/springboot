package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@RestController
@RequestMapping("/user/**")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "userList", method = RequestMethod.POST)
    public ResponseEntity<?> getUsers(@RequestBody UserParam userParam) throws AuthenticationException {
        rabbitTemplate.convertAndSend("hello",userService.getUsers());
        return userService.getUsers();
    }

    public static void main(String[] args) {
        String str = ",,";
        String[] strings = str.split(",");

        System.out.println(strings.length);
    }
}
