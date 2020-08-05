package com.naha.crimereportingsystem.admin;

import java.security.Principal;

import javax.validation.Valid;

import com.naha.crimereportingsystem.citizens.CitizenServiceImpl;
import com.naha.crimereportingsystem.complaint.ComplaintServiceImpl;
import com.naha.crimereportingsystem.police.PoliceServiceImpl;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserServiceImpl;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PoliceServiceImpl policeService;

    @Autowired
    CitizenServiceImpl citizenService;

    @Autowired
    ComplaintServiceImpl complaintService;

    @GetMapping("/admin")
    public String adminLoginRouter(Principal principal) {
        return ("redirect:/admin/" + principal.getName());
    }

    @GetMapping("/admin/{username}")
    public String adminHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        model.addAttribute("police", policeService.findAllPoliceDetails());
        model.addAttribute("citizen", citizenService.findAllcitizenDetails());
        model.addAttribute("complaints", complaintService.findAllComplaintDetails());
        return "admin/index";
    }

    @GetMapping("/admin/police/new")
    public String adminNewPoliceRoute(Model model) {
        model.addAttribute("user", new User());
        return "admin/police-new";
    }

    @PostMapping("/admin/police/new")
    public String adminNewPolicePostRoute(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", true);
            return "admin/police-new";
        }
        userService.savePoliceDetails(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/police/{policeId}/edit")
    public String adminEditPoliceRoute(Model model, @PathVariable("policeId") long id) {
        model.addAttribute("police", policeService.findSinglePoliceDetail(id));
        return "admin/police-edit";
    }

    @PostMapping("/admin/police/{policeId}/edit")
    public String adminEditPolicePostRoute(@RequestParam("name") String name, @PathVariable("policeId") long id) {
        policeService.editPoliceDetails(name, id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/police/{policeId}/delete")
    public String adminDeletePoliceRoute(@PathVariable("policeId") long id) {
        userService.deleteRolePoliceDetail(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/citizen/new")
    public String adminNewCitizenRoute(Model model) {
        model.addAttribute("user", new User());
        return "admin/citizen-new";
    }

    @PostMapping("/admin/citizen/new")
    public String adminNewCitizenPostRoute(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", true);
            return "admin/citizen-new";
        }
        userService.saveUserDetails(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/citizen/{citizenId}/edit")
    public String adminEditCitizenRoute(Model model, @PathVariable("citizenId") long id) {
        model.addAttribute("citizen", citizenService.findSingleCitizenDetail(id));
        return "admin/citizen-edit";
    }

    @PostMapping("/admin/citizen/{citizenId}/edit")
    public String adminEditCitizenPostRoute(@RequestParam("name") String name, @RequestParam("email") String email,
            @PathVariable("citizenId") long id) {
        citizenService.editCitizenDetails(id, name, email);
        return "redirect:/admin";
    }

    @GetMapping("/admin/citizen/{citizenId}/delete")
    public String adminDeleteCitizenRoute(@PathVariable("citizenId") long id) {
        userService.deleteRoleCitizenDetail(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/complaint/{complaintId}/edit")
    public String adminEditComplaintRoute(Model model, @PathVariable("complaintId") long id) {
        model.addAttribute("complaint", complaintService.findComplaintDetailsById(id));
        return "admin/complaint-edit";
    }

    @PostMapping("/admin/complaint/{complaintId}/edit")
    public String adminEditComplaintPostRoute(@RequestParam("complaint") String text,
            @RequestParam("status") String status, @PathVariable("complaintId") long id) {
        complaintService.editComplaintDetails(id, text, status);
        return "redirect:/admin";
    }

    @GetMapping("/admin/complaint/{complaintId}/delete")
    public String adminDeleteComplaintRoute(@PathVariable("complaintId") long id) {
        citizenService.deleteASingleComplaint(id);
        return "redirect:/admin";
    }

}