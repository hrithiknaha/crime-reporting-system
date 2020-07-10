package com.naha.crimereportingsystem.home;

import com.naha.crimereportingsystem.crimes.CrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CrimeService crimeService;

    @GetMapping("/")
    public String HomeRoute(Model model) {
        model.addAttribute("crimes", crimeService.findAllCrime());
        return "home";
    }

}