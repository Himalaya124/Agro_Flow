package com.AgroFlow.AgroFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficerDashboardController {

    @GetMapping("/officer_dashboard")
    public String officerDashboard() {
        return "officer_dashboard"; // officer_dashboard.html in templates
    }
}