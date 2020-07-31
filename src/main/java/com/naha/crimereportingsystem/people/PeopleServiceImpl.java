package com.naha.crimereportingsystem.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    // public List<People> getAllPeopleDetails() {
    // final List<People> peoples = new ArrayList<>();
    // peopleRepository.findAll().forEach(peoples::add);

    // return peoples;
    // }

    public People getSinglePeopleDetail(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }

    public People addSinglePeopleDetail(People people) {
        People savedPeople = peopleRepository.save(people);
        return savedPeople;
    }
}