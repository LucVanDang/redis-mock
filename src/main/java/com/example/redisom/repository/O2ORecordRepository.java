package com.example.redisom.repository;
import com.example.redisom.entity.O2ORecord;
import com.redis.om.spring.repository.RedisDocumentRepository;
import java.util.Optional;


public interface O2ORecordRepository extends RedisDocumentRepository<O2ORecord, String> {

    Optional<O2ORecord> findByRn(String rn);

    void deleteByRn(String rn);
}