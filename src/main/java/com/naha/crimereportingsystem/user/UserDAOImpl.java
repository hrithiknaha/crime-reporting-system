package com.naha.crimereportingsystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByPoliceId(long id) {
        return userRepository.findByPoliceId(id);
    }

    @Override
    public User findByCitizenId(long id) {
        return userRepository.findByCitizenId(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}