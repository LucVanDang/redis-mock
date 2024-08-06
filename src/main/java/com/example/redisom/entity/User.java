package com.example.redisom.entity;

//import com.redis.om.spring.annotations.Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Indexed @NonNull
    private String firstName;

    @Indexed
    private String middleName;

    @Indexed @NonNull
    private String lastName;

    @NonNull
    @Indexed
    String email;

    @NonNull
    @Indexed
    private int age;
}
