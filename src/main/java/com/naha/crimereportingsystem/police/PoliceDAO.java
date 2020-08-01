package com.naha.crimereportingsystem.police;

public interface PoliceDAO {
    public Iterable<Police> findAll();

    public Police findById(long id);

    public Police save(Police police);

    public void deleteById(long id);
}