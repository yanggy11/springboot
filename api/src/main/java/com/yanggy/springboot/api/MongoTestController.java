package com.yanggy.springboot.api;

import com.mongodb.util.JSON;
import com.sun.net.httpserver.Authenticator;
import com.yanggy.springboot.es.EsTest;
import com.yanggy.springboot.mongo.MongoTest;
import com.yanggy.springboot.repository.EsTestRepository;
import com.yanggy.springboot.repository.MongoTestRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangguiyun
 * @Date: 2017/12/24 10:54
 * @Description:
 */

@RestController
public class MongoTestController {

    @Autowired
    private MongoTestRepository mongoTestRepository;

    @Autowired
    private EsTestRepository esTestRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping(value = "/auth/insert")
    public String insertMongoTest(@RequestBody MongoTest mongoTest) {
        mongoTemplate.insert(mongoTest);

        EsTest esTest = new EsTest();
        esTest.setName("111");
        esTest.setPassword("111");
        esTest.setSex(1);
        esTest.setId("1");

        esTestRepository.save(esTest);

        return "SUCCESS";
    }
}
