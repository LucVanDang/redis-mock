package com.example.redisom.repository;
import com.example.redisom.entity.User;
import com.redis.om.spring.repository.RedisDocumentRepository;
import java.util.Optional;


public interface UserRepository extends RedisDocumentRepository<User, String> {

    Optional<User> findByEmail(String email);

}