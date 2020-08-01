package com.naha.crimereportingsystem.emergencyComplaint;

import java.util.List;

public interface EmergencyComplaintService {

    public List<EmergencyComplaint> findAllEmergencyComplaintDetails();

    public EmergencyComplaint findComplaintDetailsById(long id);

    public EmergencyComplaint saveComplaintDetails(EmergencyComplaint complaint);

    public EmergencyComplaint editComplaintStatusDetails(String status, long id);
}