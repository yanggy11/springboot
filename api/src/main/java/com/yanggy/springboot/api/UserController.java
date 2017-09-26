package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JwtAuthenticationRequest;
import com.yanggy.springboot.jwt.JwtAuthenticationResponse;
import com.yanggy.springboot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @ApiParam @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{

        return userService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@ApiParam @RequestBody User addedUser) throws AuthenticationException {
        return userService.register(addedUser);
    }
    @RequestMapping(value = "/user/userList", method = RequestMethod.POST)
    public ResponseEntity<?> getUsers(@ApiParam @RequestBody UserParam userParam) throws AuthenticationException {
        return userService.getUsers();
    }
}
