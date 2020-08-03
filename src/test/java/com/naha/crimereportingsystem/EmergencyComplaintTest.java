package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaint;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintRepository;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintService;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class EmergencyComplaintTest {

    @Autowired
    EmergencyComplaintServiceImpl emergencyComplaintService;

    @MockBean
    EmergencyComplaintRepository emergencyComplaintRepository;

    EmergencyComplaint emergencyComplaint = new EmergencyComplaint(1l, "No Dogs to feed", "Investigation Pending");

    @Test
    public void testSaveComplaintDetails() {

        when(emergencyComplaintRepository.save(emergencyComplaint)).thenReturn(emergencyComplaint);
        assertEquals(emergencyComplaint, emergencyComplaintService.saveComplaintDetails(emergencyComplaint));
    }

    @Test
    public void testFindComplaintDetailsById() {
        long id = 1;

        when(emergencyComplaintRepository.findById(id)).thenReturn(Optional.of(emergencyComplaint));
        assertEquals(emergencyComplaint, emergencyComplaintService.findComplaintDetailsById(id));
    }

    @Test
    public void testFindWrongComplaintDetailsById() {
        long id = 2;

        when(emergencyComplaintRepository.findById(id)).thenReturn(Optional.empty());
        assertNull(emergencyComplaintService.findComplaintDetailsById(id));
    }

    @Test
    public void testEditComplaintStatusDetail() {

        long id = 1;
        String status = "Investigation Complete";
        EmergencyComplaint editedComplaint = new EmergencyComplaint(id, "No dogs to feed", "Investigation Complete");

        when(emergencyComplaintRepository.findById(id)).thenReturn(Optional.of(emergencyComplaint));
        when(emergencyComplaintRepository.save(emergencyComplaint)).thenReturn(editedComplaint);

        assertEquals(editedComplaint, emergencyComplaintService.editComplaintStatusDetails(status, id));
    }

    @Test
    public void testFindAllEmergencyComplaintDetails() {

        List<EmergencyComplaint> complaints = new ArrayList<>();
        EmergencyComplaint complaintOne = new EmergencyComplaint(1l, "No dogs to feed", "Investigation Pending");
        EmergencyComplaint complaintTwo = new EmergencyComplaint(1l, "No dogs to feed", "Investigation Pending");

        complaints.add(complaintOne);
        complaints.add(complaintTwo);

        when(emergencyComplaintRepository.findAll()).thenReturn(complaints);
        assertEquals(complaints, emergencyComplaintService.findAllEmergencyComplaintDetails());
    }
}