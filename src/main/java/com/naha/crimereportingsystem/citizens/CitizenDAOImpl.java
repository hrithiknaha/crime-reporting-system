package com.naha.crimereportingsystem.citizens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CitizenDAOImpl implements CitizenDAO {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public Citizen save(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Iterable<Citizen> findAll() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen findById(long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    @Override
    public Citizen findByComplaintId(long id) {
        return citizenRepository.findByComplaintId(id);
    }

}