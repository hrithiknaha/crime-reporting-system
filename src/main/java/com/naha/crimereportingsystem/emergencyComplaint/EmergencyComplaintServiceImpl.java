package com.naha.crimereportingsystem.emergencyComplaint;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyComplaintServiceImpl implements EmergencyComplaintService {

    @Autowired
    EmergencyComplaintDAOImpl emergencyComplaintDAO;

    @Override
    public List<EmergencyComplaint> findAllEmergencyComplaintDetails() {
        List<EmergencyComplaint> complaints = new ArrayList<>();
        emergencyComplaintDAO.findAll().forEach(complaints::add);
        return complaints;
    }

    @Override
    public EmergencyComplaint findComplaintDetailsById(long id) {
        return emergencyComplaintDAO.findById(id);
    }

    @Override
    public EmergencyComplaint saveComplaintDetails(EmergencyComplaint complaint) {
        return emergencyComplaintDAO.save(complaint);
    }

    @Override
    public EmergencyComplaint editComplaintStatusDetails(String status, long id) {
        EmergencyComplaint complaint = findComplaintDetailsById(id);
        complaint.setStatus(status);
        return emergencyComplaintDAO.save(complaint);
    }
}