package com.example.redisom.entity;

import com.redis.om.spring.annotations.Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(prefixes = "customer:bet:{id}:segment:o2o")
public class O2ORecord {
    @Id
    private String rn;

    @Indexed @NonNull
    private String key;

    @Indexed  @NonNull
    private String value;
}
