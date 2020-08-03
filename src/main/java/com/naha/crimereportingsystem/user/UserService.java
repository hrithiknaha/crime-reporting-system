package com.naha.crimereportingsystem.user;

public interface UserService {

    public User saveUserDetails(User user);

    public User savePoliceDetails(User user);

    public User findSingleUserDetails(String username);

    public User findByPoliceId(Long id);

    public void deleteRolePoliceDetail(long id);

    public User findByCitizenId(Long id);

    public void deleteRoleCitizenDetail(long id);

}