package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    void helloReturnsGreeting() throws Exception {
        when(greetingService.greet("World")).thenReturn(new Greeting(1L, "Hello, World!"));

        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    void helloWithNameParamReturnsGreeting() throws Exception {
        when(greetingService.greet("Spring")).thenReturn(new Greeting(2L, "Hello, Spring!"));

        mockMvc.perform(get("/api/hello").param("name", "Spring"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring!"));
    }

    @Test
    void helloNamePathVariableReturnsGreeting() throws Exception {
        when(greetingService.greet("Boot")).thenReturn(new Greeting(3L, "Hello, Boot!"));

        mockMvc.perform(get("/api/hello/Boot"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Boot!"));
    }
}
