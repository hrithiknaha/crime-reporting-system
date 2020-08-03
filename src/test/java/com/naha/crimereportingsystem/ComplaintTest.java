package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.complaint.ComplaintRepository;
import com.naha.crimereportingsystem.complaint.ComplaintServiceImpl;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
public class ComplaintTest {

    @Autowired
    ComplaintServiceImpl complaintService;

    @MockBean
    ComplaintRepository complaintRepository;

    @Test
    public void testFindAllComplaintDetails() {

        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        when(complaintRepository.findAll()).thenReturn(complaints);
        assertEquals(complaints, complaintService.findAllComplaintDetails());
    }

    @Test
    public void testFindComplaintDetailsById() {
        Complaint complaint = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        when(complaintRepository.findById(1l)).thenReturn(Optional.of(complaint));
        assertEquals(complaint, complaintService.findComplaintDetailsById(1l));
    }

    @Test
    public void testFindWrongComplaintDetailsById() {
        when(complaintRepository.findById(2l)).thenReturn(Optional.empty());
        assertNull(complaintService.findComplaintDetailsById(2l));
    }

    @Test
    public void testSaveComplaintDetails() {
        Complaint complaint = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        when(complaintRepository.save(complaint)).thenReturn(complaint);
        assertEquals(complaint, complaintService.saveComplaintDetails(complaint));
    }

    @Test
    public void testEditComplaintDetails() {
        Complaint complaint = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint editedComplaint = new Complaint(1l, "No Dogs to feed", "Investigation Complete", "/images/dogs.jpg");
        when(complaintRepository.findById(1l)).thenReturn(Optional.of(complaint));
        when(complaintRepository.save(complaint)).thenReturn(editedComplaint);
        assertEquals(editedComplaint,
                complaintService.editComplaintDetails(1l, "No Dogs to feed", "Investigation Complete"));

    }

    // @Test
    // public void testAddImageToComplaint() {
    // Complaint complaint = new Complaint();
    // complaint.setId(1l);
    // complaint.setStatus("Investigation Pending");
    // complaint.setText("No dogs to feed");

    // MockMultipartFile file = new MockMultipartFile("data", "filename.txt",
    // "text/plain", "some xml".getBytes());

    // Complaint complaintWithImage = new Complaint(1l, "Investigation Pending", "No
    // dogs to feed", "/images/dog.jpg");

    // when(complaintRepository.save(complaint)).thenReturn(complaintWithImage);
    // assertEquals(complaintWithImage,
    // complaintService.addImageToComplaint("No dogs to feed", file,
    // "/images/dog.jpg"));

    // }

}