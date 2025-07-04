package com.first.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.dto.CreateUserReq;
import com.first.demo.dto.UserResponse;
import com.first.demo.model.UserModel;
import com.first.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "") String name) {
        return userService.getUserGreeting(name);
    }

    @PostMapping("/")
    public UserResponse createUser(@RequestBody CreateUserReq req) {
        UserModel user = userService.createUser(req.getName(), req.getEmail());
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
    
    @GetMapping("/all")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody CreateUserReq req) {
        UserModel updatedUser = userService.updateUser(id, req.getName(), req.getEmail());
        return new UserResponse(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());
    }
    
}
