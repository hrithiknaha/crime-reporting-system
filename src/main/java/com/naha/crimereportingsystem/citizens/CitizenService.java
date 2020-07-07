package com.naha.crimereportingsystem.citizens;

import java.util.ArrayList;
import java.util.List;

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

    public List<Citizen> findAllcitizenDetails() {
        List<Citizen> citizen = new ArrayList<>();
        citizenRepository.findAll().forEach(citizen::add);
        return citizen;
    }

    public Citizen findSingleCitizenDetail(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    public Citizen findCitizenWithHavingComplaintId(Long id) {
        return citizenRepository.findByComplaintId(id);
    }

}