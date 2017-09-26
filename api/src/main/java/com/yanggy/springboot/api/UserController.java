package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JwtAuthenticationRequest;
import com.yanggy.springboot.jwt.JwtAuthenticationResponse;
import com.yanggy.springboot.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{
        final String token = userService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException {
        return userService.register(addedUser);
    }
    @RequestMapping(value = "/user/userList", method = RequestMethod.POST)
    public Object getUsers(@RequestBody UserParam userParam) throws AuthenticationException {
        return userService.getUsers();
    }
}
