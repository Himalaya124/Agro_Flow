package com.AgroFlow.AgroFlow.controller;

import com.AgroFlow.AgroFlow.entity.Officer;
import com.AgroFlow.AgroFlow.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {

    @Autowired
    private OfficerRepository officerRepository;

    // Show signup form
    @GetMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("officer", new Officer());
        return "signup"; // return the HTML page name (signup.html)
    }

    // Handle form submission
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute Officer officer, Model model){
        if(officerRepository.existsById(officer.getOfficerId())){
            model.addAttribute("error", "Officer ID already exists!");
            return "signup";
        }

        // Save officer with plain text password
        officerRepository.save(officer);
        model.addAttribute("success", "Officer registered successfully!");
        model.addAttribute("officer", new Officer()); // reset form
        return "signup";
    }
}