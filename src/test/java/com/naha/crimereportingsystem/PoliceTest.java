package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.naha.crimereportingsystem.police.Police;
import com.naha.crimereportingsystem.police.PoliceRepository;
import com.naha.crimereportingsystem.police.PoliceServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PoliceTest {

    @MockBean
    PoliceRepository policeRepository;

    @Autowired
    PoliceServiceImpl policeService;

    @Test
    public void testFindAllPoliceDetails() {
        List<Police> polices = new ArrayList<>();

        Police policePersonnelOne = new Police(1l, "Mukund Mishra");
        Police policePersonnelTwo = new Police(2l, "T. Iyer");

        polices.add(policePersonnelOne);
        polices.add(policePersonnelTwo);

        when(policeRepository.findAll()).thenReturn(polices);
        assertEquals(polices, policeService.findAllPoliceDetails());
    }

    @Test
    public void testFindSinglePoliceDetail() {
        Police policePersonnelOne = new Police(1l, "Mukund Mishra");

        when(policeRepository.findById(1l)).thenReturn(Optional.of(policePersonnelOne));
        assertEquals(policePersonnelOne, policeService.findSinglePoliceDetail(1l));
    }

    @Test
    public void testWrongFindSinglePoliceDetail() {

        when(policeRepository.findById(2l)).thenReturn(Optional.empty());
        assertEquals(null, policeService.findSinglePoliceDetail(2l));
    }

    @Test
    public void testSavePoliceDetails() {
        Police policePersonnelOne = new Police(1l, "Mukund Mishra");
        when(policeRepository.save(policePersonnelOne)).thenReturn(policePersonnelOne);

        assertEquals(policePersonnelOne, policeService.savePoliceDetail(policePersonnelOne));
    }

    @Test
    public void testEditPoliceDetails() {
        Police policePersonnelOne = new Police(1l, "Mukund Mishra");
        Police editedPersonnelOne = new Police(1l, "Mukund Kumar Mishra");

        when(policeRepository.findById(1l)).thenReturn(Optional.of(policePersonnelOne));
        when(policeRepository.save(policePersonnelOne)).thenReturn(editedPersonnelOne);

        assertEquals(editedPersonnelOne, policeService.editPoliceDetails("Mukund Kumar Mishra", 1l));
    }
}