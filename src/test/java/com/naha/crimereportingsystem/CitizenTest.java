package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.naha.crimereportingsystem.complaint.Complaint;
import com.naha.crimereportingsystem.user.UserRepository;
import com.naha.crimereportingsystem.citizens.Citizen;
import com.naha.crimereportingsystem.citizens.CitizenRepository;
import com.naha.crimereportingsystem.citizens.CitizenService;
import com.naha.crimereportingsystem.citizens.CitizenServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CitizenTest {

    @Autowired
    CitizenServiceImpl citizenService;

    @MockBean
    CitizenRepository citizenRepository;

    @Test
    public void testFindAllCitizenDetails() {

        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        List<Citizen> citizens = new ArrayList<>();
        Citizen citizenOne = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        citizens.add(citizenOne);

        when(citizenRepository.findAll()).thenReturn(citizens);
        assertEquals(citizens, citizenService.findAllcitizenDetails());
    }

    @Test
    public void testSaveCitizenDetails() {
        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        Citizen citizen = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        when(citizenRepository.save(citizen)).thenReturn(citizen);
        assertEquals(citizen, citizenService.saveCitizenDetails(citizen));
    }

    @Test
    public void testFindSingleCitizenDetail() {
        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        Citizen citizen = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        when(citizenRepository.findById(1l)).thenReturn(Optional.of(citizen));
        assertEquals(citizen, citizenService.findSingleCitizenDetail(1l));
    }

    @Test
    public void testEditCitizenDetails() {
        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        Citizen citizen = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);
        Citizen citizenEdited = new Citizen(1l, "Mukund Mishra", "mukundmishra@gmail.com", complaints);

        when(citizenRepository.findById(1l)).thenReturn(Optional.of(citizen));
        when(citizenRepository.save(citizen)).thenReturn(citizenEdited);

        assertEquals(citizenEdited, citizenService.editCitizenDetails(1l, "Mukund Mishra", "mukundmishra@gmail.com"));
    }

    // FindCmplaintWithId
    @Test
    public void testFindCitizenWithComplaintId() {
        List<Complaint> complaints = new ArrayList<>();
        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        Complaint complaintTwo = new Complaint(2l, "No cats to feed", "Investigation Pending", "/images/cat.jpg");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        Citizen citizen = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        when(citizenRepository.findByComplaintId(1l)).thenReturn(citizen);
        assertEquals(citizen, citizenService.findCitizenWithComplaintId(1l));
    }

    @Test
    public void testAddComplaint() {

        List<Complaint> complaints = new ArrayList<>();

        Citizen citizenWithOutComplaint = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        Complaint complaintOne = new Complaint(1l, "No dogs to feed", "Investigation Pending", "/images/dog.jpg");
        complaints.add(complaintOne);

        Citizen citizenWithComplaint = new Citizen(1l, "Mukund Mishra", "mukund@gmail.com", complaints);

        when(citizenRepository.save(citizenWithOutComplaint)).thenReturn(citizenWithComplaint);
        assertEquals(citizenWithComplaint, citizenService.addComplaint(citizenWithOutComplaint, complaintOne));
    }

}