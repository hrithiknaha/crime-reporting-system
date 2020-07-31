package com.naha.crimereportingsystem.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ComplaintService {

    public List<Complaint> findAllComplaintDetails();

    public Complaint findComplaintDetailsById(long id);

    public Complaint saveComplaintDetails(Complaint complaint);

    public void deleteComplaintDetail(long id);
}