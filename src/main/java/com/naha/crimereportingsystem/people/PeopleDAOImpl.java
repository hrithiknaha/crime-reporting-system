package com.naha.crimereportingsystem.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People save(People people) {
        return peopleRepository.save(people);
    }

}