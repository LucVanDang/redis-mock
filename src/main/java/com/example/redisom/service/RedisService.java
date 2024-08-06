package com.example.redisom.service;import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedissonClient redissonClient;

    private  final ObjectMapper objectMapper;

    public <T> void saveObjectAsJson(String prefix, String key, T object) throws Exception {
        String fullKey = prefix + ":" + key;
        RBucket<String> bucket = redissonClient.getBucket(fullKey);
        String json = objectMapper.writeValueAsString(object);
        bucket.set(json);
    }

    public <T> T getObjectFromJson(String prefix, String key, Class<T> clazz) throws Exception {
        String fullKey = prefix + ":" + key;
        RBucket<String> bucket = redissonClient.getBucket(fullKey);
        String json = bucket.get();
        if (json != null) {
            return objectMapper.readValue(json, clazz);
        }
        return null;
    }

}
