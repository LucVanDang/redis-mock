package com.example.redisom.repository;

import com.example.redisom.entity.O2OWhiteList;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface O2OWhiteListRepository extends RedisDocumentRepository<O2OWhiteList, String> {
}
