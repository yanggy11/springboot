package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.jwt.JWTUser;
import com.yanggy.springboot.jwt.JwtTokenUtil;
import com.yanggy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserMapper userMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public User register(User user) {
        final String username = user.getName();
        if(userMapper.findByName(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setLastPasswordResetDate(new Date());
        userMapper.insertUser(user);

        return user;
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        JWTUser jwtUser = (JWTUser) userDetails;
        final String token = jwtTokenUtil.generateToken(jwtUser);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JWTUser user = (JWTUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    @Override
    public Object getUsers() {
        return userMapper.getUserList();
    }
}
