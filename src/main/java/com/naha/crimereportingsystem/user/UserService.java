package com.naha.crimereportingsystem.user;

import com.naha.crimereportingsystem.complaint.Complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    public void saveUserDetails(User user);

    public User findSingleUserDetails(String username);

    public User findByPoliceId(Long id);

    public void deleteRolePoliceDetail(User user);

    public User findByCitizenId(Long id);

    public void deleteRoleCitizenDetail(User user);

}