package com.naha.crimereportingsystem.citizens;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.complaint.ComplaintServiceImpl;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

import javax.validation.Valid;

@Controller
public class CitizenController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src" + "/main" + "/resources" + "/static"
            + "/images";

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CitizenServiceImpl citizenService;

    @Autowired
    ComplaintServiceImpl complaintService;

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
            @PathVariable String username, @RequestParam("file") MultipartFile file) {
        if (result.hasErrors())
            return "complaint/complaint-form";

        Citizen complaintAddedCitizen = userService.findSingleUserDetails(username).getCitizen();
        Complaint complaintWithImage = complaintService.addImageToComplaint(complaint, file, uploadDirectory);
        model.addAttribute("citizen", citizenService.addComplaint(complaintAddedCitizen, complaintWithImage));
        model.addAttribute("complaint", complaint);
        return "complaint/submission";
    }

}