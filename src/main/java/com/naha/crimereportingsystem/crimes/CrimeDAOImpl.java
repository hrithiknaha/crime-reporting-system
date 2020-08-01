package com.naha.crimereportingsystem.crimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CrimeDAOImpl implements CrimeDAO {

    @Autowired
    CrimeRepository crimeRepository;

    @Override
    public Crime save(Crime crime) {
        return crimeRepository.save(crime);
    }

    @Override
    public Iterable<Crime> findAll() {
        return crimeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        crimeRepository.deleteById(id);
    }

}