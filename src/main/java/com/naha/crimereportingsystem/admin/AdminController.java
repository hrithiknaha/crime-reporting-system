package com.naha.crimereportingsystem.admin;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;

import com.naha.crimereportingsystem.citizens.Citizen;
import com.naha.crimereportingsystem.citizens.CitizenService;
import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.complaint.ComplaintService;
import com.naha.crimereportingsystem.police.Police;
import com.naha.crimereportingsystem.police.PoliceService;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PoliceService policeService;

    @Autowired
    CitizenService citizenService;

    @Autowired
    ComplaintService complaintService;

    @GetMapping("/admin")
    public String adminLoginRouter(Principal principal) {
        System.out.println(principal.getName());
        return ("redirect:/admin/" + principal.getName());
    }

    @GetMapping("/admin/{username}")
    public String adminHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        model.addAttribute("police", policeService.findAllPoliceDetails());
        model.addAttribute("citizen", citizenService.findAllcitizenDetails());
        model.addAttribute("complaints", complaintService.findAllComplaintDetails());
        System.out.println(policeService.findAllPoliceDetails());
        return "admin/index";
    }

    @GetMapping("/admin/police/new")
    public String adminNewPoliceRoute(Model model) {
        model.addAttribute("user", new User());
        return "admin/police-new";
    }

    @PostMapping("/admin/police/new")
    public String adminNewPolicePostRoute(User user) {
        user.setRoles("ROLE_POLICE");
        userService.saveUserDetails(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/police/{policeId}/edit")
    public String adminEditPoliceRoute(Model model, @PathVariable("policeId") long id) {
        System.out.println(id);
        model.addAttribute("police", policeService.findSinglePoliceDetail(id));
        return "admin/police-edit";
    }

    @PostMapping("/admin/police/{policeId}/edit")
    public String adminEditPolicePostRoute(@RequestParam("name") String name, @PathVariable("policeId") long id) {
        Police police = policeService.findSinglePoliceDetail(id);
        police.setName(name);
        policeService.savePoliceDetail(police);
        return "redirect:/admin";
    }

    @GetMapping("/admin/police/{policeId}/delete")
    public String adminDeletePoliceRoute(@PathVariable("policeId") long id) {
        System.out.println("police id:" + id);
        User toBeDeletedPoliceUser = userService.findByPoliceId(id);
        System.out.println(toBeDeletedPoliceUser);
        userService.deleteRolePoliceDetail(toBeDeletedPoliceUser);
        return "redirect:/admin";
    }

    @GetMapping("/admin/citizen/new")
    public String adminNewCitizenRoute(Model model) {
        model.addAttribute("user", new User());
        return "admin/citizen-new";
    }

    @PostMapping("/admin/citizen/new")
    public String adminNewCitizenPostRoute(User user) {
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
        Citizen citizen = citizenService.findSingleCitizenDetail(id);
        citizen.setName(name);
        citizen.setEmail(email);
        citizenService.saveCitizenDetails(citizen);
        return "redirect:/admin";
    }

    @GetMapping("/admin/citizen/{citizenId}/delete")
    public String adminDeleteCitizenRoute(@PathVariable("citizenId") long id) {
        User toBeDeletedCitizenUser = userService.findByCitizenId(id);
        userService.deleteRoleCitizenDetail(toBeDeletedCitizenUser);
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
        Complaint complaint = complaintService.findComplaintDetailsById(id);
        complaint.setText(text);
        complaint.setStatus(status);
        complaintService.saveComplaintDetails(complaint);
        return "redirect:/admin";
    }

    @GetMapping("/admin/complaint/{complaintId}/delete")
    public String adminDeleteComplaintRoute(@PathVariable("complaintId") long id) {
        Citizen citizen = citizenService.findSingleCitizenDetail(id);
        System.out.println(citizen);
        // citizen.removeComplaint(id);
        return "redirect:/admin";
    }

}