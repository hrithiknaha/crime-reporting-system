package com.naha.crimereportingsystem.complaint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank(message = "Please enter the Complaint")
    @Size(min = 2, message = "Complaint must have a minimum of 2 characters")
    @Column(length = 3000)
    private String text;

    @NotNull
    @NotBlank(message = "Please enter the Complaint Status")
    @Size(min = 2, message = "Status must have a minimum of 2 characters")
    private String status = "Investigation Pending";

    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

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

    public Complaint(long id, String text, String status, String imagePath) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.imagePath = imagePath;
    }

}