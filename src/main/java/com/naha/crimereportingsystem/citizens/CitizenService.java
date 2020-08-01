package com.naha.crimereportingsystem.citizens;

import java.util.List;

import com.naha.crimereportingsystem.complaint.Complaint;

public interface CitizenService {

    public Citizen saveCitizenDetails(Citizen citizen);

    public List<Citizen> findAllcitizenDetails();

    public Citizen findSingleCitizenDetail(Long id);

    public Citizen editCitizenDetails(long id, String name, String Email);

    public Citizen findCitizenWithComplaintId(Long id);

    public void deleteASingleComplaint(long id);

    public Citizen addComplaint(Citizen citizen, Complaint complaint);
}