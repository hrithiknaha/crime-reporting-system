package com.naha.crimereportingsystem.citizens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen saveCitizenDetails(Citizen citizen) {
        Citizen savedCitizen = citizenRepository.save(citizen);
        return savedCitizen;
    }

}