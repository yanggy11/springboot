# 集成elasticsearch2.4

pom中引入spring-data-elasticsearch依赖
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        </dependency>
```

application.yml中加入elasticsearch配置
```
spring:
  data:
    elasticsearch:
      # 集群名
      cluster-name: yanggy
      # 连接节点,注意在集群中通信都是9300端口，否则会报错无法连接上！
      cluster-nodes: localhost:9300
```

增加es测试model
```
@Document(indexName = "es_test", type = "post", shards = 1, replicas = 0)
@Data
public class EsTest {
    private String id;

    private String name;
    private String password;
    private int sex;
}
```

其中@Document注解用于指定es的indexname等信息，@Data注解用于自动生成getter和setter方法。

因为用的是spring-data,所以需要创建repository接口，创建EsTestRepository
```
    package com.yanggy.springboot.repository;

    import com.yanggy.springboot.es.EsTest;
    import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    /**
     * Created by yangguiyun on 2017/12/26.
     */

    @Repository
    public interface EsTestRepository extends ElasticsearchRepository<EsTest, String> {
        List<EsTest> findByName(String name);
    }
```

在controller中引用EsTestRepository，这里只是测试用，并不需要提供service类
```
package com.yanggy.springboot.api;

import com.yanggy.springboot.es.EsTest;
import com.yanggy.springboot.mongo.MongoTest;
import com.yanggy.springboot.repository.EsTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangguiyun
 * @Date: 2017/12/24 10:54
 * @Description:
 */

@RestController
public class MongoTestController {
    @Autowired
    private EsTestRepository esTestRepository;
    @PostMapping(value = "/auth/insert")
    public String insertMongoTest() {
        EsTest esTest = new EsTest();
        esTest.setName("111");
        esTest.setPassword("111");
        esTest.setSex(1);
        esTest.setId("1");

        esTestRepository.save(esTest);

        return "SUCCESS";
    }
}
```

以上即是springboot整合elasticsearch2.4.0的过程。
