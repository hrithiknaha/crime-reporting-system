package com.naha.crimereportingsystem.emergencyComplaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class EmergencyController {

    @Autowired
    EmergencyComplaintServiceImpl emergencyComplaintService;

    @GetMapping("/emergency-complaint/{complaintId}/status/edit")
    public String editComplaintStatus(Model model, @PathVariable long complaintId) {
        model.addAttribute("emergencyComplaint", emergencyComplaintService.findComplaintDetailsById(complaintId));
        return "emergency-complaint/status-form";
    }

    @PostMapping("/emergency-complaint/{complaintId}/status/edit")
    public String editComplaintStatusPost(@PathVariable long complaintId, @RequestParam("status") String status) {

        EmergencyComplaint complaint = emergencyComplaintService.findComplaintDetailsById(complaintId);
        complaint.setStatus(status);
        emergencyComplaintService.saveComplaintDetails(complaint);
        System.out.println(status);
        return "redirect:/police";
    }
}