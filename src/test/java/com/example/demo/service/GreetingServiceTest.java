package com.example.demo.service;

import com.example.demo.model.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    void greetReturnsGreetingWithName() {
        Greeting greeting = greetingService.greet("Spring");
        assertThat(greeting.getContent()).isEqualTo("Hello, Spring!");
    }

    @Test
    void greetAssignsIncrementingId() {
        Greeting first = greetingService.greet("A");
        Greeting second = greetingService.greet("B");
        assertThat(second.getId()).isEqualTo(first.getId() + 1);
    }
}
