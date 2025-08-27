package com.AgroFlow.AgroFlow.controller;

import com.AgroFlow.AgroFlow.entity.Officer;
import com.AgroFlow.AgroFlow.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // allow frontend requests
public class AuthController {


    @Autowired
    private OfficerService officerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Officer officer){
        boolean valid = officerService.validateLogin(officer.getOfficerId(), officer.getPassword());
        if(valid) return ResponseEntity.ok("Login successful");
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    @PostMapping("/signup")
    public String signup(@RequestBody Officer officer) {
        try {
            officerService.registerOfficer(officer);
            return "Signup successful!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}