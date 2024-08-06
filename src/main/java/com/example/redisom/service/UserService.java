package com.example.redisom.service;

import com.example.redisom.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RedisService redisService;


    public User save(User user) throws Exception {
        redisService.saveObjectAsJson("prefix", "key", user);
        return null;
    }

    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    public void deleteById(String id) {

    }

    public List<User> findAll() throws Exception {
        return Collections.singletonList(redisService.getObjectFromJson("prefix", "key", User.class));
    }
}
