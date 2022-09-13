package com.shebogholo.starter;

import com.shebogholo.starter.user.User;
import com.shebogholo.starter.user.UserRepository;
import com.shebogholo.starter.utils.Message;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {
    // API entry point
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping
    public Message index() {
        return new Message("API is up and running...");
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository){
        return args -> {
            // create new instances of users
            User user4 = new User("ddd", "ddd", "ddd@gmail.com");
            User user5 = new User("eee", "eee", "eee@gmail.com");
            User user6 = new User("fff", "fff", "fff@gmail.com");
            // insert users to database
            userRepository.saveAll(List.of(user4, user5, user6));
        };
    }
}
