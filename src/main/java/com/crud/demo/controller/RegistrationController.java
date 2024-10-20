package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.demo.model.Registration;
import com.crud.demo.service.RegistrationService;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registerUserCreds")
    public String registerUser(@ModelAttribute Registration registration, RedirectAttributes redirectAttributes) {
                String message = registrationService.registerUser(registration);

        if (message.equals("Registration successful")) {
            redirectAttributes.addFlashAttribute("message", "User registered successfully!");
                        return "redirect:/login"; 
        } else {
            redirectAttributes.addFlashAttribute("error", message);
                        return "redirect:/registration";
        }
    }
}
