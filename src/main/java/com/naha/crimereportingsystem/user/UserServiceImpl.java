package com.naha.crimereportingsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUserDetails(User user) {
        userRepository.save(user);
    }

    public void savePoliceDetails(User user) {
        user.setRoles("ROLE_POLICE");
        userRepository.save(user);
    }

    public User findSingleUserDetails(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByPoliceId(Long id) {
        return userRepository.findByPoliceId(id);
    }

    public void deleteRolePoliceDetail(long id) {
        User toBeDeletedUser = findByPoliceId(id);
        userRepository.delete(toBeDeletedUser);
    }

    public User findByCitizenId(Long id) {
        return userRepository.findByCitizenId(id);
    }

    public void deleteRoleCitizenDetail(long id) {
        User toBeDeletedUser = findByCitizenId(id);
        userRepository.delete(toBeDeletedUser);
    }
}
