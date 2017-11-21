package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.service.AuthService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yangguiyun on 2017/9/27.
 */

@RestController
@RequestMapping("/auth/**")
public class AuthController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Resource
    private AuthService authService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserParam userParam) throws AuthenticationException {
        amqpTemplate.convertAndSend("hello", userParam);
        return authService.login(userParam.getUsername(), userParam.getPassword());
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody User user) throws AuthenticationException {
        return authService.register(user);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setPassword("123456");
        user.setAge(28);
        user.setEmail("derrick.yang@centling.com");
        user.setId(1);
        user.setName("derrick");
        user.setPhone("15610089787");
        user.setSex(0);
        user = null;
        Object length = Optional.ofNullable(user).map(User::getName).orElse("anonymous");

        System.out.println(length);

        List<String> names = Arrays.asList("name1","name3","name4","name2","name5","name6","name10","name7","name8","name9");
        List<SimpleGrantedAuthority> authorities = names.stream().limit(20).skip(3).sorted((p1,p2) -> p1.compareTo(p2)).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        System.out.println(authorities);


    }
}
