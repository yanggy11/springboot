package com.yanggy.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class Role implements Serializable {
    private long id;
    private String role;
    private String roleName;
}
