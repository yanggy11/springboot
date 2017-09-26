package com.yanggy.springboot.security;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.findByName(name);
        if(null == user) {
            throw  new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        }
        user.setRoles(userMapper.getUserRoles(user.getId()));
        return JwtUserFactory.create(user);
    }
}
