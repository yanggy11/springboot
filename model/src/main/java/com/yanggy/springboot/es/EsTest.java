package com.yanggy.springboot.es;

import com.yanggy.springboot.entity.Role;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2017/12/26 21:05
 * @Description:
 */

@Document(indexName = "es_test", type = "post", shards = 1, replicas = 0)
@Data
public class EsTest {
    private String id;

    private String name;
    private String password;
    private int sex;

    private List<Role> roles;
}
