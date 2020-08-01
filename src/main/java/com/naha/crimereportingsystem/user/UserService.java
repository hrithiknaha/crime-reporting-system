package com.naha.crimereportingsystem.user;

public interface UserService {

    public void saveUserDetails(User user);

    public void savePoliceDetails(User user);

    public User findSingleUserDetails(String username);

    public User findByPoliceId(Long id);

    public void deleteRolePoliceDetail(long id);

    public User findByCitizenId(Long id);

    public void deleteRoleCitizenDetail(long id);

}