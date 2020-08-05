package com.naha.crimereportingsystem.citizens;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.user.User;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "Name must have minimum of 2 Characters")
    private String name;
    private String email;

    @Valid
    @OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint;

    public long getId() {
        return id;
    }

    public List<Complaint> getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint savedComplaint) {
        this.complaint.add(savedComplaint);
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

    public Citizen(long id, String name, String email, List<Complaint> complaint) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.complaint = complaint;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n Name: " + name;
    }
}