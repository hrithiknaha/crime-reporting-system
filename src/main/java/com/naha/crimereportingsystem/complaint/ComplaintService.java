package com.naha.crimereportingsystem.complaint;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ComplaintService {

    public List<Complaint> findAllComplaintDetails();

    public Complaint findComplaintDetailsById(long id);

    public Complaint saveComplaintDetails(Complaint complaint);

    public Complaint editComplaintDetails(long id, String text, String status);

    public void deleteComplaintDetail(long id);

    public Complaint addImageToComplaint(Complaint complaint, MultipartFile file, String uploadDirectory);
}