package com.naha.crimereportingsystem.citizens;

import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CitizenController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String citizenRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public void citizenRegister(User user) {
        userService.addUserDetails(user);
    }

}