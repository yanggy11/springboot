package com.yanggy.springboot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by yangguiyun on 2017/9/26.
 */

@Data
public class UserParam {

    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String password;
}
