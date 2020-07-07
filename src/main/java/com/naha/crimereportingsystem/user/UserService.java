package com.naha.crimereportingsystem.user;

import com.naha.crimereportingsystem.complaint.Complaint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUserDetails(User user) {
        userRepository.save(user);
    }

    public User findSingleUserDetails(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByPoliceId(Long id) {
        return userRepository.findByPoliceId(id);
    }

    public void deleteRolePoliceDetail(User user) {
        userRepository.delete(user);
    }

    public User findByCitizenId(Long id) {
        return userRepository.findByCitizenId(id);
    }

    public void deleteRoleCitizenDetail(User user) {
        userRepository.delete(user);
    }

}