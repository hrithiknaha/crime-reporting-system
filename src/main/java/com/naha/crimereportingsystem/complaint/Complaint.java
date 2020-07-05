package com.naha.crimereportingsystem.complaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private String status = "Investigation Pending";

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Complaint() {
    }

    public Complaint(long id, String text, String status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

}