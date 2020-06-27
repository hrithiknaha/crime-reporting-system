package com.naha.crimereportingsystem.people;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaint;

@Entity
public class People {

    @Id

    private String id;
    private String name;
    private String phoneNumber;

    @OneToMany(targetEntity = EmergencyComplaint.class, cascade = CascadeType.ALL)
    private List<EmergencyComplaint> emergencyComplaint;

    public People() {

    }

    public People(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public List<EmergencyComplaint> getEmergencyComplaint() {
        return emergencyComplaint;
    }

    public void setEmergencyComplaint(List<EmergencyComplaint> emergencyComplaint) {
        this.emergencyComplaint = emergencyComplaint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(final String name) {
        this.name = name;
    }

}