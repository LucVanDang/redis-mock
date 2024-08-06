package com.example.redisom;

import com.example.redisom.entity.User;
import com.example.redisom.repository.UserRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.example.redisom.*")
@RequiredArgsConstructor
public class RedisOmApplication {

    private final UserRepository userRepo;

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            userRepo.deleteAll();
            User john = User.of("Zack", "de la Rocha", "zack@ratm.com", 19);
            User tim = User.of("Tim", "Commerford", "tim@ratm.com", 14);
            User tom = User.of("Tom", "Morello", "tom@ratm.com", 16);
            User brad = User.of("Brad", "Wilk", "brad@ratm.com", 22);
            userRepo.saveAll(List.of(john, tim, tom, brad));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisOmApplication.class, args);
    }

}
