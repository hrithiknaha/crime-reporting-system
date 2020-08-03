package com.naha.crimereportingsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOImpl userDAO;

    public User saveUserDetails(User user) {
        return userDAO.save(user);
    }

    public User savePoliceDetails(User user) {
        user.setRoles("ROLE_POLICE");
        return userDAO.save(user);
    }

    public User findSingleUserDetails(String username) {
        return userDAO.findByUsername(username);
    }

    public User findByPoliceId(Long id) {
        return userDAO.findByPoliceId(id);
    }

    public void deleteRolePoliceDetail(long id) {
        User toBeDeletedUser = findByPoliceId(id);
        userDAO.delete(toBeDeletedUser);
    }

    public User findByCitizenId(Long id) {
        return userDAO.findByCitizenId(id);
    }

    public void deleteRoleCitizenDetail(long id) {
        User toBeDeletedUser = findByCitizenId(id);
        userDAO.delete(toBeDeletedUser);
    }
}
