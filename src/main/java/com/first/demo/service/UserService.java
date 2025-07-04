package com.first.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
