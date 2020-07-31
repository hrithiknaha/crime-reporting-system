package com.naha.crimereportingsystem.people;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PeopleService {

    public People addSinglePeopleDetail(People people);

    // Not Used
    public People getSinglePeopleDetail(Long id);
}