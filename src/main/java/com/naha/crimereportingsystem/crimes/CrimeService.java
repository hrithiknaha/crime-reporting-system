package com.naha.crimereportingsystem.crimes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CrimeService {

    public void addCrimeDetail(Crime crime);

    public void deleteCrimeDetail(long id);

    public List<Crime> findAllCrime();

}