package com.yanggy.springboot.mapper;


import com.yanggy.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangguiyun on 2017/6/1.
 */

@Mapper
public interface UserMapper {
    int insertUser(User user);
    User selectById(@Param("id") long id);
    User findByName(@Param("username") String name);
    User findByNameAndPassword(@Param("username") String username, @Param("password") String password);
    List<User> getUserList();
    List<String>getUserRoles(@Param("userId") Long userId);
}
