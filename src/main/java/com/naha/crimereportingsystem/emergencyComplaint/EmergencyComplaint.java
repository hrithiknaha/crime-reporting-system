package com.naha.crimereportingsystem.emergencyComplaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmergencyComplaint {

    @Id
    private String id;
    private String emergencyComplaint;
    private String status;

    public String getEmergencyComplaint() {
        return emergencyComplaint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmergencyComplaint(String emergencyComplaint) {
        this.emergencyComplaint = emergencyComplaint;
    }

    public EmergencyComplaint(String id, String emergencyComplaint, String status) {
        this.id = id;
        this.emergencyComplaint = emergencyComplaint;
        this.status = status;
    }

    public EmergencyComplaint() {
    }

}