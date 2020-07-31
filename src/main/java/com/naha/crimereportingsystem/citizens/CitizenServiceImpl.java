package com.naha.crimereportingsystem.citizens;

import java.util.ArrayList;
import java.util.List;

import com.naha.crimereportingsystem.complaint.Complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenServiceImpl implements CitizenService {

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

    public void deleteASingleComplaint(long id, Citizen citizen) {
        int index = 0;
        for (Complaint c : citizen.getComplaint()) {
            if (c.getId() == id) {
                index = citizen.getComplaint().indexOf(c);
                break;
            }
        }
        citizen.getComplaint().remove(index);
    }
}