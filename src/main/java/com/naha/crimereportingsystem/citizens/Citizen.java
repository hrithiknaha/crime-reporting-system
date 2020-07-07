package com.naha.crimereportingsystem.citizens;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.user.User;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    @OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint;

    public void removeComplaint(long id) {
        for (Complaint c : complaint) {
            if (c.getId() == id) {
                complaint.remove(c);
            }
        }
    }

    public long getId() {
        return id;
    }

    public List<Complaint> getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint savedComplaint) {
        complaint.add(savedComplaint);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Citizen() {
    }

    public Citizen(long id, String name, String email, User user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.complaint = (List<Complaint>) new Complaint();
    }

    @Override
    public String toString() {
        return "id: " + id + "\n Name: " + name;
    }
}