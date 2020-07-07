package com.naha.crimereportingsystem.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    public List<Complaint> findAllComplaintDetails() {
        List<Complaint> complaints = new ArrayList<>();
        complaintRepository.findAll().forEach(complaints::add);
        return complaints;
    }

    public Complaint findComplaintDetailsById(long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    public Complaint saveComplaintDetails(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public void deleteComplaintDetail(long id) {
        complaintRepository.deleteById(id);
    }
}