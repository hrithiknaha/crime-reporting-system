package com.naha.crimereportingsystem.citizens;

import java.util.ArrayList;
import java.util.List;

import com.naha.crimereportingsystem.complaint.Complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    CitizenDAOImpl citizenDAO;

    @Override
    public Citizen saveCitizenDetails(Citizen citizen) {
        Citizen savedCitizen = citizenDAO.save(citizen);
        return savedCitizen;
    }

    @Override
    public List<Citizen> findAllcitizenDetails() {
        List<Citizen> citizen = new ArrayList<>();
        citizenDAO.findAll().forEach(citizen::add);
        return citizen;
    }

    @Override
    public Citizen findSingleCitizenDetail(Long id) {
        return citizenDAO.findById(id);
    }

    @Override
    public Citizen editCitizenDetails(long id, String name, String email) {
        Citizen toBeEditedCitizen = findSingleCitizenDetail(id);
        toBeEditedCitizen.setName(name);
        toBeEditedCitizen.setEmail(email);
        return citizenDAO.save(toBeEditedCitizen);
    }

    @Override
    public Citizen findCitizenWithComplaintId(Long id) {
        return citizenDAO.findByComplaintId(id);
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

        citizenDAO.save(toBeDeletedComplaintsCitizen);
    }

    @Override
    public Citizen addComplaint(Citizen citizen, Complaint complaint) {
        citizen.setComplaint(complaint);
        citizenDAO.save(citizen);
        return citizen;
    }

}