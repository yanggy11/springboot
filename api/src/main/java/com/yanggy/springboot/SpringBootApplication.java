package com.yanggy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yangguiyun on 2017/9/22.
 */

//@EnableTransactionManagement
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
