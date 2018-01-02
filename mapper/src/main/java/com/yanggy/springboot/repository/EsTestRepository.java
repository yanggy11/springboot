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
