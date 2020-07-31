package com.naha.crimereportingsystem.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public People addSinglePeopleDetail(People people) {
        People savedPeople = peopleRepository.save(people);
        return savedPeople;
    }

    // Not Used
    public People getSinglePeopleDetail(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }
}