package com.naha.crimereportingsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUserDetails(User user) {
        userRepository.save(user);
    }

    public User findSingleUserDetails(String username) {
        return userRepository.findByUsername(username);
    }

    // public void addUserComplaint(User user){

    // }
}