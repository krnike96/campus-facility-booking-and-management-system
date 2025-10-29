package com.campus.fbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Handles the request for the login page
    @GetMapping("/login")
    public String login() {
        return "login"; // Refers to src/main/resources/templates/login.html
    }

    // Placeholder for the main dashboard after login
    // We will build the full dashboard content in the next phase
    @GetMapping("/dashboard")
    public String dashboard() {
        // This will be replaced by a proper dashboard view soon.
        return "dashboard";
    }
}