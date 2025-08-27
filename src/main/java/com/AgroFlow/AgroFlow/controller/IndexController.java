package com.AgroFlow.AgroFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String officerDashboard() {
        return "index"; // index.html in templates
    }
}