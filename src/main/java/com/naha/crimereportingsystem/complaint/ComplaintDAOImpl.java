package com.naha.crimereportingsystem.complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public Complaint save(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Iterable<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint findById(long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        complaintRepository.deleteById(id);

    }

}