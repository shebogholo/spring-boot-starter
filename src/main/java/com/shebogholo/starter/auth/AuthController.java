package com.shebogholo.starter.auth;

import com.shebogholo.starter.exception.ApiRequestException;
import com.shebogholo.starter.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest){
        try {
            return authService.register(registerRequest);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/login")
    public Optional<User> login(@RequestBody LoginRequest loginRequest){
        try {
            return authService.login(loginRequest);
        }catch (Exception e){
            throw new ApiRequestException("User with email "+loginRequest.email()+" does not exist!");
        }
    }
}
