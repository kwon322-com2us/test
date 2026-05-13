package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceTest {

    private HelloService helloService;

    @BeforeEach
    void setUp() {
        helloService = new HelloService();
    }

    @Test
    void greetWithNullReturnsDefault() {
        assertThat(helloService.greet(null)).isEqualTo("Hello, Spring Boot!");
    }

    @Test
    void greetWithBlankReturnsDefault() {
        assertThat(helloService.greet("  ")).isEqualTo("Hello, Spring Boot!");
    }

    @Test
    void greetWithNameReturnsPersonalized() {
        assertThat(helloService.greet("World")).isEqualTo("Hello, World!");
    }

    @Test
    void addReturnsSumOfTwoIntegers() {
        assertThat(helloService.add(3, 4)).isEqualTo(7);
    }
}
