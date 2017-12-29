package com.yanggy.springboot;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yangguiyun on 2017/9/22.
 */

@EnableTransactionManagement
@EnableAdminServer
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
