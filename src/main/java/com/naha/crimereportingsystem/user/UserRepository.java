package com.naha.crimereportingsystem.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByPoliceId(long id);
}