package com.yanggy.springboot.api;

import com.yanggy.springboot.dto.UserParam;
import com.yanggy.springboot.service.UserService;
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
@RequestMapping("/user/**")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userList", method = RequestMethod.POST)
    public ResponseEntity<?> getUsers(@ApiParam @RequestBody UserParam userParam) throws AuthenticationException {
        return userService.getUsers();
    }
}
