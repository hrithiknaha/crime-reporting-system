package com.naha.crimereportingsystem.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    private long id;
    private String name;

    public long getId() {
        return id;
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

    public Admin() {
    }

    public Admin(long id, String name) {
        this.id = id;
        this.name = name;
    }
}