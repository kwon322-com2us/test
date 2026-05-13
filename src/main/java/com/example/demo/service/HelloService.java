package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, Spring Boot!";
        }
        return "Hello, " + name + "!";
    }

    public int add(int a, int b) {
        return a + b;
    }
}
