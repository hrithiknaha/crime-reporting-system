package com.naha.crimereportingsystem.complaint;

import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    // List<Complaint> findAll();
}