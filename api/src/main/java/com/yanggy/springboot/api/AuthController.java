package com.yanggy.springboot.api;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JwtAuthenticationRequest;
import com.yanggy.springboot.service.AuthService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/27.
 */

@RestController
@RequestMapping("/auth/**")
public class AuthController {

    @Resource
    private AuthService authService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @ApiParam @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        return authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@ApiParam @RequestBody User user) throws AuthenticationException {
        return authService.register(user);
    }
}
