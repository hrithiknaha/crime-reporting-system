package com.naha.crimereportingsystem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.naha.crimereportingsystem.crimes.Crime;
import com.naha.crimereportingsystem.crimes.CrimeRepository;
import com.naha.crimereportingsystem.crimes.CrimeServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CrimeTest {

    @Autowired
    CrimeServiceImpl crimeService;

    @MockBean
    CrimeRepository crimeRepository;

    @Test
    public void testFindAllCrime() {
        List<Crime> crimes = new ArrayList<>();

        Crime crimeOne = new Crime(1l, "Abinav Tiwari", "Noida", 23, "Not Solved", "Missing");
        Crime crimeTwo = new Crime(2l, "Shailesh Sharma", "Ahmedabad", 27, "Not Solved", "Missing");

        crimes.add(crimeOne);
        crimes.add(crimeTwo);

        when(crimeRepository.findAll()).thenReturn(crimes);
        assertEquals(crimes, crimeService.findAllCrime());
    }

    @Test
    public void testAddCrimeDetails() {
        Crime crimeOne = new Crime(1l, "Abinav Tiwari", "Noida", 23, "Not Solved", "Missing");

        when(crimeRepository.save(crimeOne)).thenReturn(crimeOne);
        assertEquals(crimeOne, crimeService.addCrimeDetail(crimeOne));
    }

}