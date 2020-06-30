package com.naha.crimereportingsystem.emergencyComplaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmergencyComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String complaint;
    private String status = "Investigation Pending";

    public String getComplaint() {
        return complaint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public EmergencyComplaint(long id, String complaint, String status) {
        this.id = id;
        this.complaint = complaint;
        this.status = status;
    }

    public EmergencyComplaint(String complaint, String status) {
        this.complaint = complaint;
        this.status = status;
    }

    public EmergencyComplaint() {
    }

}