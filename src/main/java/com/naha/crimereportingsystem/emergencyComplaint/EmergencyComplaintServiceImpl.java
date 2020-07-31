package com.naha.crimereportingsystem.emergencyComplaint;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyComplaintServiceImpl implements EmergencyComplaintService {

    @Autowired
    EmergencyComplaintRepository emergencyComplaintRepository;

    public List<EmergencyComplaint> findAllEmergencyComplaintDetails() {
        List<EmergencyComplaint> complaints = new ArrayList<>();
        emergencyComplaintRepository.findAll().forEach(complaints::add);
        return complaints;
    }

    public EmergencyComplaint findComplaintDetailsById(long id) {
        return emergencyComplaintRepository.findById(id).orElse(null);
    }

    public EmergencyComplaint saveComplaintDetails(EmergencyComplaint complaint) {
        return emergencyComplaintRepository.save(complaint);
    }
}