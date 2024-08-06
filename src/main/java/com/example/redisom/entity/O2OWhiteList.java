package com.example.redisom.entity;

import com.redis.om.spring.annotations.Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Document(prefixes = "customer:segment:o2o:catalog")
public class O2OWhiteList {
    @Id
    private String id;

    private String name;

    private String description;

    private String group;

    LocalDateTime updatedDateTime;

    private String updatedBy;

    private String keyType;
}
