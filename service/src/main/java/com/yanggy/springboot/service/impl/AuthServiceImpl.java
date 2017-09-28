package com.yanggy.springboot.service.impl;

import com.yanggy.springboot.entity.User;
import com.yanggy.springboot.jwt.JWTUser;
import com.yanggy.springboot.jwt.JwtTokenUtil;
import com.yanggy.springboot.mapper.UserMapper;
import com.yanggy.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Transactional
@Service("authService")
public class AuthServiceImpl implements AuthService {

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
    public ResponseEntity<?> register(User user) {
        final String username = user.getName();
        if(userMapper.findByName(username)!=null) {
            return new ResponseEntity<Object>(HttpStatus.CONTINUE);
        }
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encodePassword(user.getPassword(), user.getName()));
        userMapper.insertUser(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        JWTUser jwtUser = (JWTUser) userDetails;
        final String token = jwtTokenUtil.generateToken(jwtUser);
        return new ResponseEntity<Object>(this.tokenHead + token, HttpStatus.OK);
    }
}