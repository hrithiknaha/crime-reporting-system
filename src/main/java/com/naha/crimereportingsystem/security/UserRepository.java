package com.naha.crimereportingsystem.security;

import java.util.Optional;

import com.naha.crimereportingsystem.security.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}