package com.naha.crimereportingsystem.complaint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.naha.crimereportingsystem.citizens.Citizen;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotBlank(message = "Please enter the Complaint")
    @Size(min = 10, message = "Complaint must have 10 words")
    private String text;

    @NotNull
    @NotBlank(message = "Please enter the Complaint Status")
    @Size(min = 10, message = "Status must have 10 words")
    private String status = "Investigation Pending";

    @ManyToOne
    private Citizen citizen;

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