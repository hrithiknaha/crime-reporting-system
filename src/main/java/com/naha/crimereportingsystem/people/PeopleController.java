package com.naha.crimereportingsystem.people;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/")
    public List<People> allPeopleIndex() {
        return peopleService.getAllPeopleDetails();
    }

    @GetMapping("/{id}")
    public People singlePeopleIndex(@PathVariable String id) {
        return peopleService.getSinglePeopleDetail(id);
    }

    @PostMapping("/")
    public void postSinglePostIndex(@RequestBody People people) {
        peopleService.addSinglePeopleDetail(people);
    }
}