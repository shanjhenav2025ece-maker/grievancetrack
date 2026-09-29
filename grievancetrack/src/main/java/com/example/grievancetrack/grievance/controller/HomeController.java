package com.example.grievancetrack.grievance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/grievance-form")
    public String grievanceForm() {
        return "grievance-form";
    }

    @GetMapping("/grievances")
    public String grievances() {
        return "grievances";
    }

    @GetMapping("/escalations")
    public String escalations() {
        return "escalations";
    }
}