package com.naha.crimereportingsystem.crimes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrimeServiceImpl implements CrimeService {

    @Autowired
    CrimeDAOImpl crimeDao;

    public void addCrimeDetail(Crime crime) {
        crimeDao.save(crime);
    }

    public void deleteCrimeDetail(long id) {
        crimeDao.deleteById(id);
    }

    public List<Crime> findAllCrime() {
        List<Crime> crimes = new ArrayList<>();
        crimeDao.findAll().forEach(crimes::add);
        return crimes;
    }
}