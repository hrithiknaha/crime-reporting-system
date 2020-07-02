package com.naha.crimereportingsystem.citizens;

import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

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

    @GetMapping("/user")
    public String loginRouter(Principal principal) {
        System.out.println(principal.getName());
        return ("redirect:/users/" + principal.getName());
    }

    @GetMapping("/users/{username}")
    public String userRoute(Principal principal, Model model, @PathVariable String username) {

        model.addAttribute("user", userService.findSingleUserDetails(username));

        return "users";
    }

    @GetMapping("/users/{username}/complaint")
    public String userRegisterComplaintRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        return "complaint-index";
    }

    @PostMapping("/users/complaint")
    public String userRegisterComplaintPostRoute(Model model, User user) {
        System.out.println(user);
        // userService.addUserDetails(user);

        return "redirect:/users/" + user.getName() + "/complaint/status";
    }

    @GetMapping("/users/{username}/complaint/status")
    public String userComplaintStatusRoute() {
        return "complaint-status";
    }

}