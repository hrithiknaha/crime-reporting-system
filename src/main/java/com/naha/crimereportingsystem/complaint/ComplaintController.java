package com.naha.crimereportingsystem.complaint;

import com.naha.crimereportingsystem.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping("/complaint/{complaintId}/status/edit")
    public String editComplaintStatus(Model model, @PathVariable long complaintId) {
        model.addAttribute("complaint", complaintService.findComplaintDetailsById(complaintId));
        return "complaint/status-form";
    }

    @PostMapping("/complaint/{complaintId}/status/edit")
    public String editComplaintStatusPost(@PathVariable long complaintId, @RequestParam("status") String status) {
        Complaint complaint = complaintService.findComplaintDetailsById(complaintId);
        complaint.setStatus(status);
        complaintService.saveComplaintDetails(complaint);
        System.out.println(status);
        return "redirect:/police";
    }
}