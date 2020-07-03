package com.naha.crimereportingsystem.people;

import com.naha.crimereportingsystem.citizens.Citizen;

import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Long> {

}
