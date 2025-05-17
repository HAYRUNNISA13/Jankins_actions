package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Demo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot on Kubernetes!";
    }
}
