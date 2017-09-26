package com.yanggy.springboot.entity;

import java.io.Serializable;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public class UserRole implements Serializable {
    private long id;
    private long userId;
    private long roleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
