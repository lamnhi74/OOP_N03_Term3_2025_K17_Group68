package com.example.quanlynhahang.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping("/")
    public String home() {
        return "login";
    }
}
