package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.security.JwtTokenUtil;
import com.yanggy.springboot.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public User register(User userToAdd) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}
