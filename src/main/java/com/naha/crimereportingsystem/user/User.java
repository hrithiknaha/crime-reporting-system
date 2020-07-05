package com.naha.crimereportingsystem.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.naha.crimereportingsystem.citizens.Citizen;
import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.police.Police;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private boolean active = true;
    private String roles = "ROLE_USER";

    @OneToOne(targetEntity = Citizen.class, cascade = CascadeType.ALL)
    private Citizen citizen;

    @OneToOne(targetEntity = Police.class, cascade = CascadeType.ALL)
    private Police police;

    public String getUsername() {
        return username;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(int id, String username, String password, boolean active, String roles, Citizen citizen,
            Police police) {
        this.id = id;
        this.citizen = citizen;
        this.police = police;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\nusername: " + this.username;
    }

}