package com.naha.crimereportingsystem.citizens;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.user.MyUserDetails;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
public class CitizenController {

    @Autowired
    UserService userService;

    @Autowired
    CitizenService citizenService;

    @GetMapping("/register")
    public String registerRoute(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public void registerPostRoute(User user) {
        userService.saveUserDetails(user);
    }

    @GetMapping("/user")
    public String loginRouter(Principal principal) {
        System.out.println(principal.getName());
        return ("redirect:/user/" + principal.getName());
    }

    @GetMapping("/user/{username}")
    public String citizenHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        return "complaint/index";
    }

    @GetMapping("/user/{username}/complaint")
    public String citizenAddComplaintRoute(Model model, @PathVariable String username) {
        // System.out.println(userService.findSingleUserDetails(username).getCitizen().getComplaint());
        model.addAttribute("username", username);
        model.addAttribute("complaint", new Complaint());
        return "complaint/complaint-form";
    }

    @PostMapping("/user/{username}/complaint")
    public String citizenAddComplaintPostRoute(Model model, Complaint complaint, @PathVariable String username) {
        Citizen complaintAddedCitizen = userService.findSingleUserDetails(username).getCitizen();
        complaintAddedCitizen.setComplaint(complaint);
        Citizen savedCitizen = citizenService.saveCitizenDetails(complaintAddedCitizen);
        model.addAttribute("citizen", savedCitizen);
        model.addAttribute("complaint", complaint);
        return "complaint/submission";
    }

}