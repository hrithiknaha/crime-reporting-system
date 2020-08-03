package com.naha.crimereportingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.naha.crimereportingsystem.citizens.Citizen;
import com.naha.crimereportingsystem.citizens.CitizenService;
import com.naha.crimereportingsystem.police.Police;
import com.naha.crimereportingsystem.user.User;
import com.naha.crimereportingsystem.user.UserRepository;
import com.naha.crimereportingsystem.user.UserService;
import com.naha.crimereportingsystem.user.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserTest {

    @Autowired
    UserServiceImpl userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testSaveUserDetails() {
        Citizen citizen = new Citizen(1l, "Hrithik Naha", "me@gmail.com", null);
        User newUser = new User(1, "naha", "naha", true, "ROLES_USER", citizen, null, null);

        when(userRepository.save(newUser)).thenReturn(newUser);
        assertEquals(newUser, userService.saveUserDetails(newUser));
    }

    @Test
    public void testSavePoliceUserDetails() {
        Police police = new Police(1l, "Mukund Mishra");
        User newUser = new User(1, "naha", "naha", true, "ROLES_USER", null, police, null);

        when(userRepository.save(newUser)).thenReturn(newUser);
        assertEquals(newUser, userService.savePoliceDetails(newUser));
    }

    @Test
    public void testFindSingleUserDetails() {
        Citizen citizen = new Citizen(1l, "Hrithik Naha", "me@gmail.com", null);
        User newUser = new User(1, "naha", "naha", true, "ROLES_USER", citizen, null, null);

        when(userRepository.findByUsername("naha")).thenReturn(newUser);
        assertEquals(newUser, userService.findSingleUserDetails("naha"));
    }

    @Test
    public void testFindByCitizenId() {
        Citizen citizen = new Citizen(1l, "Hrithik Naha", "me@gmail.com", null);
        User newUser = new User(1, "naha", "naha", true, "ROLES_USER", citizen, null, null);

        when(userRepository.findByCitizenId(1l)).thenReturn(newUser);
        assertEquals(newUser, userService.findByCitizenId(1l));
    }

    @Test
    public void testFindByPoliceId() {
        Police police = new Police(1l, "Mukund Mishra");
        User newUser = new User(1, "naha", "naha", true, "ROLES_USER", null, police, null);

        when(userRepository.findByPoliceId(1l)).thenReturn(newUser);
        assertEquals(newUser, userService.findByPoliceId(1l));
    }
}