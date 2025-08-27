package com.AgroFlow.AgroFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginPageController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html from templates
    }
}
