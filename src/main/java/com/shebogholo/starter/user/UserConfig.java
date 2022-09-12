package com.shebogholo.starter.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    // Populate users table
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            // create new instances of users
            User user1 = new User("aaa", "aaa", "aaa@gmail.com");
            User user2 = new User("bbb", "bbb", "bbb@gmail.com");
            User user3 = new User("ccc", "ccc", "ccc@gmail.com");

            // insert users to database
            userRepository.saveAll(List.of(user1, user2, user3));
        };
    }
}
