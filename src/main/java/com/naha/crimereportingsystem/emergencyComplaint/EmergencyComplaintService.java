package com.naha.crimereportingsystem.emergencyComplaint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface EmergencyComplaintService {

    public List<EmergencyComplaint> findAllEmergencyComplaintDetails();

    public EmergencyComplaint findComplaintDetailsById(long id);

    public EmergencyComplaint saveComplaintDetails(EmergencyComplaint complaint);
}