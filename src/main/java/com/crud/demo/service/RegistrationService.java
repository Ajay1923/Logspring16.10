package com.crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.model.Registration;
import com.crud.demo.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String registerUser(Registration registration) {
        if (registrationRepository.existsByUsername(registration.getUsername())) {
            return "Username already exists"; // Handle case where username is already taken
        }
        
        // Save the new user to the database
        registrationRepository.save(registration);
        return "Registration successful";
    }
}
