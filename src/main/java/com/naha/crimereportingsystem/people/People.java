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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String phoneNumber;

    @OneToOne(targetEntity = EmergencyComplaint.class, cascade = CascadeType.ALL)
    private EmergencyComplaint emergencyComplaint;

    public People() {

    }

    public People(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emergencyComplaint = new EmergencyComplaint();
    }

    public EmergencyComplaint getEmergencyComplaint() {
        return emergencyComplaint;
    }

    public void setEmergencyComplaint(EmergencyComplaint emergencyComplaint) {
        this.emergencyComplaint = emergencyComplaint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "id: " + id + "\nName:" + name + "\nE-Complaint" + emergencyComplaint.getComplaint();
    }
}