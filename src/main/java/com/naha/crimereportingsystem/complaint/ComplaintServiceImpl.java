package com.naha.crimereportingsystem.complaint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public List<Complaint> findAllComplaintDetails() {
        List<Complaint> complaints = new ArrayList<>();
        complaintRepository.findAll().forEach(complaints::add);
        return complaints;
    }

    @Override
    public Complaint findComplaintDetailsById(long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    @Override
    public Complaint saveComplaintDetails(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint editComplaintDetails(long id, String text, String status) {
        Complaint toBeEditedComplaint = findComplaintDetailsById(id);
        toBeEditedComplaint.setText(text);
        toBeEditedComplaint.setStatus(status);
        return saveComplaintDetails(toBeEditedComplaint);
    }

    @Override
    public void deleteComplaintDetail(long id) {
        complaintRepository.deleteById(id);
    }

}