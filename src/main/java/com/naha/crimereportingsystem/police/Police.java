package com.naha.crimereportingsystem.police;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Police {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Police() {
    }

    public Police(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id :" + id + "/nname:" + name;
    }
}