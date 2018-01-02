package com.yanggy.springboot.repository;

import com.yanggy.springboot.mongo.MongoTest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yangguiyun
 * @Date: 2017/12/22 15:59
 * @Description:
 */

@Repository
public interface MongoTestRepository extends PagingAndSortingRepository<MongoTest, String>{
    MongoTest findById(String id);
}
