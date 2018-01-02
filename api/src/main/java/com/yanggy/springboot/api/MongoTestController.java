package com.yanggy.springboot.api;

import com.yanggy.springboot.entity.Role;
import com.yanggy.springboot.es.EsTest;
import com.yanggy.springboot.mongo.MongoTest;
import com.yanggy.springboot.repository.EsTestRepository;
import com.yanggy.springboot.repository.MongoTestRepository;
import org.elasticsearch.index.fielddata.plain.NonEstimatingEstimator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        try {
            mongoTemplate.insert(mongoTest);

            EsTest esTest = new EsTest();
            esTest.setName("111");
            esTest.setPassword("111");
            esTest.setSex(1);
            List<Role> roles = new ArrayList<>();
            Role role1 = new Role();
            Role role2 = new Role();
            role1.setRole("admin");
            role1.setRoleName("管理员");
            role1.setId(1);
            role2.setRole("user");
            role2.setRoleName("用户");
            role2.setId(2);

            roles.add(role1);
            roles.add(role2);
            esTest.setRoles(roles);
            esTestRepository.save(esTest);

            Iterable i = esTestRepository.findAll();
            i.forEach(esTest1 -> {
                EsTest esTest2 = (EsTest)esTest1;
                System.out.println(esTest1);
                System.out.println(esTest1);
            });
            System.out.println(i);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "SUCCESS";
    }
}
