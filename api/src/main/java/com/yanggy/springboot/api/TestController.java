package com.yanggy.springboot.api;

import com.yanggy.springboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/25.
 */

@RestController
public class TestController {
    @Resource
    private UserMapper userMapper;
    @PostMapping(value = "/test")
    public Object userList() {
        return userMapper.getUserList();
    }
}
