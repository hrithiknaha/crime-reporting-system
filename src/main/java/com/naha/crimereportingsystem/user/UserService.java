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

}