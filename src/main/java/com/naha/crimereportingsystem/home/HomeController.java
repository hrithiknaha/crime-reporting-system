package com.naha.crimereportingsystem.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String HomeRoute() {
        return "home";
    }

    @GetMapping("/admin")
    public String AdminROutes() {
        return "admin";
    }
}