package com.example.redisom.service;

import com.example.redisom.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PrefixProvider {

    public String getPrefix(User user) {
        if (user.getAge() > 18) {
            return "adult";
        } else {
            return "minor";
        }
    }
}
