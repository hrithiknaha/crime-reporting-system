package com.naha.crimereportingsystem.police;

import java.security.Principal;

import com.naha.crimereportingsystem.complaint.ComplaintService;
import com.naha.crimereportingsystem.crimes.CrimeService;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaint;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintService;
import com.naha.crimereportingsystem.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class PoliceController {

    @Autowired
    UserService userService;

    @Autowired
    ComplaintService complaintService;

    @Autowired
    EmergencyComplaintService emergencyComplaintService;

    @Autowired
    CrimeService crimeService;

    @GetMapping("/police")
    public String policeLoginRouter(Principal principal) {
        System.out.println(principal.getName());
        return ("redirect:/police/" + principal.getName());
    }

    @GetMapping("/police/{username}")
    public String citizenHomeRoute(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findSingleUserDetails(username));
        model.addAttribute("complaints", complaintService.findAllComplaintDetails());
        model.addAttribute("emergencyComplaints", emergencyComplaintService.findAllEmergencyComplaintDetails());
        model.addAttribute("crimes", crimeService.findAllCrime());
        return "police/index";
    }
}