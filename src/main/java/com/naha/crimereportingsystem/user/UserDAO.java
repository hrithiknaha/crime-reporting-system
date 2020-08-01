package com.naha.crimereportingsystem.user;

public interface UserDAO {
    public User save(User user);

    public User findByUsername(String username);

    public User findByPoliceId(long id);

    public User findByCitizenId(long id);

    public void delete(User user);
}