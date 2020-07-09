package com.naha.crimereportingsystem.crimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CrimeController {

    @Autowired
    CrimeService crimeService;

    @GetMapping("/crime/new")
    public String addNewCrimeRoute(Model model) {
        model.addAttribute("crime", new Crime());
        return "crime/add-crime-form";
    }

    @PostMapping("/crime/new")
    public String addNewCrimePostRoute(Crime crime, BindingResult result) {
        if (result.hasErrors())
            return "crime/add-crime-form";

        crimeService.addCrimeDetail(crime);

        return "redirect:/police";
    }

}