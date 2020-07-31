package com.naha.crimereportingsystem.citizens;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CitizenService {

    public Citizen saveCitizenDetails(Citizen citizen);

    public List<Citizen> findAllcitizenDetails();

    public Citizen findSingleCitizenDetail(Long id);

    public Citizen findCitizenWithHavingComplaintId(Long id);
}