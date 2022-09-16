package com.shebogholo.starter.user;

import com.shebogholo.starter.auth.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, User user){
        userRepository.findById(userId).ifPresent(
                user1 -> {
                    user1.setFirstName(user.getFirstName());
                    user1.setLastName(user.getLastName());
                    user1.setEmail(user.getEmail());
                    // save changes to db
                    userRepository.save(user1);
                }
        );
    }
}
