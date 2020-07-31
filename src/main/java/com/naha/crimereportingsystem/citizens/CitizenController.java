package com.naha.crimereportingsystem.citizens;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.user.MyUserDetails;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserService;
import com.naha.crimereportingsystem.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
public class CitizenController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CitizenServiceImpl citizenService;

    @GetMapping("/register")
    public String registerRoute(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPostRoute(@Valid User user, BindingResult result) {
        if (result.hasErrors())
            return "register";
        userService.saveUserDetails(user);
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String userLoginRouter(Principal principal) {
        return ("redirect:/user/" + principal.getName());
    }

    @GetMapping("/user/{username}")
    public String citizenHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        return "complaint/index";
    }

    @GetMapping("/user/{username}/complaint")
    public String citizenAddComplaintRoute(Model model, @PathVariable String username) {
        model.addAttribute("username", username);
        model.addAttribute("complaint", new Complaint());
        return "complaint/complaint-form";
    }

    @PostMapping("/user/{username}/complaint")
    public String citizenAddComplaintPostRoute(Model model, @Valid Complaint complaint, BindingResult result,
            @PathVariable String username) {
        if (result.hasErrors())
            return "complaint/complaint-form";

        Citizen complaintAddedCitizen = userService.findSingleUserDetails(username).getCitizen();

        model.addAttribute("citizen", citizenService.addComplaint(complaintAddedCitizen, complaint));
        model.addAttribute("complaint", complaint);
        return "complaint/submission";
    }

}