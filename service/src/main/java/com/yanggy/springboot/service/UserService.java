package com.yanggy.springboot.service;

import com.yanggy.springboot.entity.User;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public interface UserService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
