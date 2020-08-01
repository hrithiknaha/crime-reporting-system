package com.naha.crimereportingsystem.emergencyComplaint;

public interface EmergencyComplaintDAO {
    public EmergencyComplaint findById(long id);

    public Iterable<EmergencyComplaint> findAll();

    public EmergencyComplaint save(EmergencyComplaint emergencyComplaint);
}