package com.naha.crimereportingsystem.complaint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintDAOImpl complaintDAO;

    @Override
    public List<Complaint> findAllComplaintDetails() {
        List<Complaint> complaints = new ArrayList<>();
        complaintDAO.findAll().forEach(complaints::add);
        return complaints;
    }

    @Override
    public Complaint findComplaintDetailsById(long id) {
        return complaintDAO.findById(id);
    }

    @Override
    public Complaint saveComplaintDetails(Complaint complaint) {
        return complaintDAO.save(complaint);
    }

    @Override
    public Complaint editComplaintDetails(long id, String text, String status) {
        Complaint toBeEditedComplaint = findComplaintDetailsById(id);
        toBeEditedComplaint.setText(text);
        toBeEditedComplaint.setStatus(status);
        return complaintDAO.save(toBeEditedComplaint);
    }

    @Override
    public void deleteComplaintDetail(long id) {
        complaintDAO.deleteById(id);
    }

}