package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yangguiyun on 2017/6/1.
 */

@Data
public class User implements Serializable {
    private long id;
    private String name;
    private String password;
    private int sex;
    private int age;
    private String email;
    private  String phone;
}
