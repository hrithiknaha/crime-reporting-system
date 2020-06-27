package com.naha.crimereportingsystem.people;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> getAllPeopleDetails() {
        final List<People> peoples = new ArrayList<>();
        peopleRepository.findAll().forEach(peoples::add);

        return peoples;
    }

    public People getSinglePeopleDetail(String id) {
        return peopleRepository.findById(id).orElse(null);
    }

    public String addSinglePeopleDetail(People people) {
        People savedPeople = peopleRepository.save(people);
        return savedPeople.getId();
    }
}