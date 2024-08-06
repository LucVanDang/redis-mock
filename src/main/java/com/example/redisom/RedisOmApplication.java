package com.example.redisom;

import com.example.redisom.entity.O2ORecord;
import com.example.redisom.entity.O2OWhiteList;
import com.example.redisom.repository.O2ORecordRepository;
import com.example.redisom.repository.O2OWhiteListRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.example.redisom.*")
@RequiredArgsConstructor
public class RedisOmApplication {

    private final O2ORecordRepository o2ORecordRepository;
    private final O2OWhiteListRepository o2OWhiteListRepository;

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            o2OWhiteListRepository.deleteAll();
            int listSize = 10;
            List<O2OWhiteList> o2OWhiteLists = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                O2OWhiteList test = new O2OWhiteList("test" + i, "test" + i, "test" + i,
                        "test" + i, LocalDateTime.now(), "test" + i, "test" + i);
                o2OWhiteLists.add(test);
            }
            o2OWhiteListRepository.saveAll(o2OWhiteLists);



            o2ORecordRepository.deleteAll();
            int accountSize = 10000000;
            List<O2ORecord> list = new ArrayList<>();
            for (int i = 0; i < accountSize; i++) {
                O2ORecord john = O2ORecord.of( "Rocha", "zack@ratm.com");
                list.add(john);
            }
            o2ORecordRepository.saveAll(list);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisOmApplication.class, args);
    }

}
