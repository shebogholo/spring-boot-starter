package com.shebogholo.starter.auth;

import com.shebogholo.starter.user.User;
import com.shebogholo.starter.user.UserRepository;
import com.shebogholo.starter.utils.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    // register
    public void register(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(this.passwordService.passwordEncoder().encode(registerRequest.password()))
                .build();
        // todo: Check if email is valid
        // todo: Check if email is not taken

        // Store user to DB
        userRepository.save(user);
    }

    // login
    public Optional<User> login(LoginRequest loginRequest) {
        String password = this.passwordService.passwordEncoder().encode(loginRequest.password());
//        System.out.println("-----------------");
//
//        System.out.println(password);

        Optional<User> user =  userRepository.findByEmail(loginRequest.email());
        user.ifPresent(
                a -> {
                    System.out.println(a.getPassword());
                });
        return user;
    }

}
