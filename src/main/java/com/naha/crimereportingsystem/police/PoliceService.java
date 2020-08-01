package com.naha.crimereportingsystem.police;

import java.util.List;

public interface PoliceService {

    public List<Police> findAllPoliceDetails();

    public Police findSinglePoliceDetail(Long id);

    public Police savePoliceDetail(Police police);

    public Police editPoliceDetails(String name, long id);

    // Not Used
    public void deletePoliceDetail(long id);
}