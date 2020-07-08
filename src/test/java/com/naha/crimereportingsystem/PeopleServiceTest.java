package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.naha.crimereportingsystem.people.People;
import com.naha.crimereportingsystem.people.PeopleRepository;
import com.naha.crimereportingsystem.people.PeopleService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    PeopleService peopleService;

    @MockBean
    PeopleRepository peopleRepository;

    @Test
    public void findByIdPeople() {
        long id = 1;
        People people = new People(1, "Hrithik Naha", "9876543210");
        System.out.println(people.getEmergencyComplaint().getComplaint());
        when(peopleRepository.findById(id)).thenReturn(Optional.of(people));

        assertEquals(peopleService.getSinglePeopleDetail(id), people,
                "It should match the detail of the person with the id");
    }

    @Test
    public void addSinglePeopleDetail() {
        People people = new People(1, "Hrithik Naha", "9876543210");
        when(peopleRepository.save(people)).thenReturn(people);

        assertEquals(peopleService.addSinglePeopleDetail(people), people, "It should add the people Detail");
    }
}