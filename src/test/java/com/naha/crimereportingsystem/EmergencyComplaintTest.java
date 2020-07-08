package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaint;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintRepository;
import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaintService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmergencyComplaintTest {

    @Autowired
    EmergencyComplaintService emergencyComplaintService;

    @Mock
    EmergencyComplaintRepository emergencyComplaintRepository;

    @Test
    public void findByIdEmergencyComplaint() {
        long id = 1;
        EmergencyComplaint emergencyComplaint = new EmergencyComplaint(1, "No Dogs to feed", "Investigation Pending");

        when(emergencyComplaintRepository.findById(id)).thenReturn(Optional.of(emergencyComplaint));

        assertEquals(emergencyComplaintService.findComplaintDetailsById(id), emergencyComplaint);
    }
}