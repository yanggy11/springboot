package com.yanggy.springboot.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangguiyun
 * @Date: 2017/12/22 14:58
 * @Description:
 */

@Data
@Document(collection = "mongo_test")
public class MongoTest implements Serializable{
    @Id
    private String id;
    private String username;
    private String password;
    private int sex;
    private Date createDate;
    private Date updateDate;
}
