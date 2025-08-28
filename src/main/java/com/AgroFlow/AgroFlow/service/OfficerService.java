package com.AgroFlow.AgroFlow.service;

import com.AgroFlow.AgroFlow.entity.Officer;
import com.AgroFlow.AgroFlow.repository.OfficerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfficerService {

    private final OfficerRepository officerRepository;
    private final PasswordEncoder passwordEncoder;

    public OfficerService(OfficerRepository officerRepository,
                          PasswordEncoder passwordEncoder) {
        this.officerRepository = officerRepository;
        this.passwordEncoder  = passwordEncoder;
    }

    @Transactional
    public Officer registerOfficer(Officer officer) {
        if (officerRepository.existsById(officer.getOfficerId())) {
            throw new IllegalStateException("Officer ID already exists");
        }
        officer.setPassword(passwordEncoder.encode(officer.getPassword()));
        return officerRepository.save(officer);
    }

    public boolean validateLogin(String officerId, String rawPassword) {
        return officerRepository.findByOfficerId(officerId)
                .map(o -> passwordEncoder.matches(rawPassword, o.getPassword()))
                .orElse(false);
    }

}
