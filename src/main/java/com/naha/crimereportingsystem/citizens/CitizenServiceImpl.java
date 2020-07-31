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

    @Override
    public Citizen saveCitizenDetails(Citizen citizen) {
        Citizen savedCitizen = citizenRepository.save(citizen);
        return savedCitizen;
    }

    @Override
    public List<Citizen> findAllcitizenDetails() {
        List<Citizen> citizen = new ArrayList<>();
        citizenRepository.findAll().forEach(citizen::add);
        return citizen;
    }

    @Override
    public Citizen findSingleCitizenDetail(Long id) {
        return citizenRepository.findById(id).orElse(null);
    }

    @Override
    public Citizen editCitizenDetails(long id, String name, String email) {
        Citizen toBeEditedCitizen = findSingleCitizenDetail(id);
        toBeEditedCitizen.setName(name);
        toBeEditedCitizen.setEmail(email);
        return citizenRepository.save(toBeEditedCitizen);
    }

    @Override
    public Citizen findCitizenWithComplaintId(Long id) {
        return citizenRepository.findByComplaintId(id);
    }

    @Override
    public void deleteASingleComplaint(long id) {

        Citizen toBeDeletedComplaintsCitizen = findCitizenWithComplaintId(id);

        int index = 0;
        for (Complaint c : toBeDeletedComplaintsCitizen.getComplaint()) {
            if (c.getId() == id) {
                index = toBeDeletedComplaintsCitizen.getComplaint().indexOf(c);
                break;
            }
        }
        toBeDeletedComplaintsCitizen.getComplaint().remove(index);

        citizenRepository.save(toBeDeletedComplaintsCitizen);
    }

    @Override
    public Citizen addComplaint(Citizen citizen, Complaint complaint) {
        citizen.setComplaint(complaint);
        citizenRepository.save(citizen);
        return citizen;
    }

}