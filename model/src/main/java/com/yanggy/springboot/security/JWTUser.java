package com.yanggy.springboot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by yangguiyun on 2017/9/26.
 */
public class JWTUser implements UserDetails {
    private long userId;
    private  String username;
    private  String password;
    private  String email;
    private  Collection<? extends GrantedAuthority> authorities;
    private  Date lastPasswordResetDate;
    public JWTUser(
            long id,
            String username,
            String password,
            String email,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public long getUserId() {
        return userId;
    }
}
