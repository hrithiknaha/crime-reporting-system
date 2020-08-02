package com.naha.crimereportingsystem.complaint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintDAOImpl complaintDAO;

    @Override
    public List<Complaint> findAllComplaintDetails() {
        List<Complaint> complaints = new ArrayList<>();
        complaintDAO.findAll().forEach(complaints::add);
        return complaints;
    }

    @Override
    public Complaint findComplaintDetailsById(long id) {
        return complaintDAO.findById(id);
    }

    @Override
    public Complaint saveComplaintDetails(Complaint complaint) {
        return complaintDAO.save(complaint);
    }

    @Override
    public Complaint editComplaintDetails(long id, String text, String status) {
        Complaint toBeEditedComplaint = findComplaintDetailsById(id);
        toBeEditedComplaint.setText(text);
        toBeEditedComplaint.setStatus(status);
        return complaintDAO.save(toBeEditedComplaint);
    }

    @Override
    public void deleteComplaintDetail(long id) {
        complaintDAO.deleteById(id);
    }

    @Override
    public Complaint addImageToComplaint(Complaint complaint, MultipartFile file, String uploadDirectory) {
        Path imagePath = Paths.get(uploadDirectory, file.getOriginalFilename());
        try {
            Files.write(imagePath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        complaint.setImagePath("/images/" + imagePath.getFileName());
        return complaintDAO.save(complaint);
    }

}