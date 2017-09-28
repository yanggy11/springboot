package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

//@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntity<?> getUsers() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return new ResponseEntity<Object>(userMapper.getUserList(),HttpStatus.OK);
    }
}