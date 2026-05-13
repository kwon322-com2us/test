package com.example.demo.controller;

import com.example.demo.dto.GreetingResponse;
import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public GreetingResponse hello() {
        return new GreetingResponse(helloService.greet(null));
    }

    @GetMapping("/hello/{name}")
    public GreetingResponse helloName(@PathVariable String name) {
        return new GreetingResponse(helloService.greet(name));
    }
}
