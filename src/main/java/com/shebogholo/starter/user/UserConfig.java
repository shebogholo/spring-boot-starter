package com.shebogholo.starter.user;

import com.shebogholo.starter.utils.PasswordService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    // Populate users table
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordService  passwordService){
        return args -> {
            User user = User.builder()
                    .firstName("Waziri")
                    .lastName("Shebogholo")
                    .email("shebogholo@gmail.com")
                    .password(passwordService.passwordEncoder().encode("1995jhgsdj@.ld"))
                    .build();
            // insert users to database
            userRepository.saveAll(List.of(user));
        };
    }
}
