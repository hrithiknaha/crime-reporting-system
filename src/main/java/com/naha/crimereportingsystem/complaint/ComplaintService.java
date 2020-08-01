package com.naha.crimereportingsystem.complaint;

import java.util.List;

public interface ComplaintService {

    public List<Complaint> findAllComplaintDetails();

    public Complaint findComplaintDetailsById(long id);

    public Complaint saveComplaintDetails(Complaint complaint);

    public Complaint editComplaintDetails(long id, String text, String status);

    public void deleteComplaintDetail(long id);
}