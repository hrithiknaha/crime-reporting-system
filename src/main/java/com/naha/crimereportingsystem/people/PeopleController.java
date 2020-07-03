package com.naha.crimereportingsystem.people;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private PeopleService peopleService;

    @GetMapping("/emergency-complaint")
    public String emergencyComplaintIndex(Model model) {
        model.addAttribute("people", new People());
        return "emergency-complaint/index";
    }

    @PostMapping("/emergency-complaint")
    public RedirectView emergencyComplaintIndexPost(RedirectAttributes redir, People people) {
        People savedPeople = peopleService.addSinglePeopleDetail(people);

        RedirectView redirectView = new RedirectView("/emergency-complaint-submission", true);
        redir.addFlashAttribute("savedPeople", savedPeople);
        return redirectView;
    }

    @GetMapping("/emergency-complaint-submission")
    public String emergencyComplaintSubmissionIndex() {
        return "emergency-complaint/submission";
    }

    @PostMapping("/emergency-complaint-status")
    public String emergencyComplaintStatus(@RequestParam("emergency-complaint-status") long id, Model model) {
        System.out.println("Emergency Being " + id);
        model.addAttribute("peopleComplaint", peopleService.getSinglePeopleDetail(id));
        return "emergency-complaint/status";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<People> emergencyComaplaintList() {
        return peopleService.getAllPeopleDetails();
    }

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