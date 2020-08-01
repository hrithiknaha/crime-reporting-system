package com.naha.crimereportingsystem.crimes;

import java.util.List;

public interface CrimeService {

    public void addCrimeDetail(Crime crime);

    public void deleteCrimeDetail(long id);

    public List<Crime> findAllCrime();

}