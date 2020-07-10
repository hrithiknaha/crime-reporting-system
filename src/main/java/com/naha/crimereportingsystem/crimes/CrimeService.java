package com.naha.crimereportingsystem.crimes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrimeService {

    @Autowired
    CrimeRepository crimeRepository;

    public void addCrimeDetail(Crime crime) {
        crimeRepository.save(crime);
    }

    public void deleteCrimeDetail(long id) {
        crimeRepository.deleteById(id);
    }

    public List<Crime> findAllCrime() {
        List<Crime> crimes = new ArrayList<>();
        crimeRepository.findAll().forEach(crimes::add);
        return crimes;
    }

}