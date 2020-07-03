package com.naha.crimereportingsystem.citizens;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @OneToOne(targetEntity = Complaint.class, cascade = CascadeType.ALL)
    private Complaint complaint;

    public long getId() {
        return id;
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
    }
}