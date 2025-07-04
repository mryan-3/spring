package com.first.demo.service;


import org.springframework.stereotype.Service;
import java.util.List;

import com.first.demo.dto.UserResponse;
import com.first.demo.model.UserModel;
import com.first.demo.repository.UserRepository;

@Service
public class UserService {
    public String getUserGreeting(String name) {
        return "Hello, " + name + "!";
    }

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(String name, String email) {
        UserModel user = new UserModel(name, email);
        return userRepository.save(user);
    }
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public UserModel updateUser(Long id, String name, String email) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (name != null && !name.trim().isEmpty()) {
            user.setName(name);
        }
        
        // Only update email if it's provided (not null or empty)
        if (email != null && !email.trim().isEmpty()) {
            user.setEmail(email);
        }
         
           return userRepository.save(user);
           
        }
        return null; 
    }
}
