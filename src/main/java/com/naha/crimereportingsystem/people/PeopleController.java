package com.naha.crimereportingsystem.people;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintService;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintServiceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PeopleController {

    @Autowired
    private PeopleServiceImpl peopleService;

    @Autowired
    EmergencyComplaintServiceImpl emergencyComplaintService;

    @GetMapping("/emergency-complaint")
    public String emergencyComplaintIndex(Model model) {
        model.addAttribute("people", new People());
        return "emergency-complaint/index";
    }

    @Valid
    @PostMapping("/emergency-complaint")
    public String emergencyComplaintIndexPost(Model model, @Valid People people, BindingResult result) {
        if (result.hasErrors()) {
            return "emergency-complaint/index";
        }
        People savedPeople = peopleService.addSinglePeopleDetail(people);
        model.addAttribute("savedPeople", savedPeople);
        return "emergency-complaint/submission";
    }

    @PostMapping("/emergency-complaint-status")
    public String emergencyComplaintStatus(@RequestParam("emergency-complaint-status") long id, Model model) {
        System.out.println("Emergency Being " + id);
        System.out.println(emergencyComplaintService.findComplaintDetailsById(id));
        model.addAttribute("peopleComplaint", emergencyComplaintService.findComplaintDetailsById(id));
        return "emergency-complaint/status";
    }

    // @GetMapping("/emergency-complaint-submission")
    // public String emergencyComplaintSubmissionIndex() {
    // return "emergency-complaint/submission";
    // }

    // @GetMapping("/list")
    // @ResponseBody
    // public List<People> emergencyComaplaintList() {
    // return peopleService.getAllPeopleDetails();
    // }

    // @GetMapping("")
    // public List<People> allPeopleIndex() {
    // return peopleService.getAllPeopleDetails();
    // }

    // @GetMapping("/{id}")
    // public People singlePeopleIndex(@PathVariable String id) {
    // return peopleService.getSinglePeopleDetail(id);
    // }

    // @PostMapping("")
    // public void postSinglePostIndex(@RequestBody People people) {
    // peopleService.addSinglePeopleDetail(people);
    // }
}