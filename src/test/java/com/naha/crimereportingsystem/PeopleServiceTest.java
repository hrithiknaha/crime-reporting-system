package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.naha.crimereportingsystem.emergencyComplaint.EmergencyComplaint;
import com.naha.crimereportingsystem.people.People;
import com.naha.crimereportingsystem.people.PeopleRepository;
import com.naha.crimereportingsystem.people.PeopleService;
import com.naha.crimereportingsystem.people.PeopleServiceImpl;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    PeopleServiceImpl peopleService;

    @MockBean
    PeopleRepository peopleRepository;

    @Test
    public void addSinglePeopleDetail() {
        long phoneNumber = 9876543210l;
        People people = new People(1, "Hrithik Naha", phoneNumber,
                new EmergencyComplaint(2, "No dogs to feed", "Investigation Pending"));

        when(peopleRepository.save(people)).thenReturn(people);
        People savedPeople = peopleRepository.save(people);

        assertEquals(savedPeople, peopleService.addSinglePeopleDetail(people), "It should add the people Detail");
    }
}