package com.example.redisom;

import com.example.redisom.entity.User;
import com.example.redisom.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class RedisOmApplication {

    private final RedisService redisService;

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            User john = User.of("Zack", "de la Rocha", "zack@ratm.com", 19);
            redisService.saveObjectAsJson("prefix", "key", john);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisOmApplication.class, args);
    }

}
