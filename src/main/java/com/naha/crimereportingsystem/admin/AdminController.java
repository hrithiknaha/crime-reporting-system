package com.naha.crimereportingsystem.admin;

import java.security.Principal;

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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PoliceService policeService;

    @GetMapping("/admin")
    public String adminLoginRouter(Principal principal) {
        System.out.println(principal.getName());
        return ("redirect:/admin/" + principal.getName());
    }

    @GetMapping("/admin/{username}")
    public String adminHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        model.addAttribute("police", policeService.findAllPoliceDetails());
        System.out.println(policeService.findAllPoliceDetails());
        return "admin/index";
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

}