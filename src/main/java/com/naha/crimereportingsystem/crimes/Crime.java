package com.naha.crimereportingsystem.crimes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank(message = "Please enter name of the Criminal")
    private String name;

    @NotNull
    @NotBlank(message = "Please enter location")
    private String location;

    @NotNull
    private int age;

    @NotNull
    @NotBlank(message = "Please enter age of the Criminal")
    private String status;

    @NotNull
    @NotBlank(message = "Please enter type of the Criminal")
    private String type;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Crime() {
    }

    public Crime(long id, String name, String location, int age, String status, String type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.age = age;
        this.status = status;
        this.setType(type);
    }
}