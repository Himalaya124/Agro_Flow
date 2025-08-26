package com.AgroFlow.AgroFlow.service;

import com.AgroFlow.AgroFlow.entity.Officer;
import com.AgroFlow.AgroFlow.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    public Officer registerOfficer(Officer officer) throws Exception {
        if(officerRepository.existsById(officer.getOfficerId())){
            throw new Exception("Officer ID already exists!");
        }

        // Save password as plain text (no encoding)
        // officer.setPassword(passwordEncoder.encode(officer.getPassword()));  <-- REMOVE THIS
        return officerRepository.save(officer);
    }

    public boolean validateLogin(String officerId, String password){
        return officerRepository.findByOfficerId(officerId)
                .map(officer -> officer.getPassword().equals(password)) // compare plain text
                .orElse(false);
    }

}