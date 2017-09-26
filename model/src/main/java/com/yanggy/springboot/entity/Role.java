package com.yanggy.springboot.entity;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public class Role implements Serializable {
    private long id;
    private String role;
    private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
