package com.naha.crimereportingsystem.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String username;
    private String password;
    private boolean active = true;
    private String roles = "USER";

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User(int id, String name, String username, String password, boolean active, String roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

}