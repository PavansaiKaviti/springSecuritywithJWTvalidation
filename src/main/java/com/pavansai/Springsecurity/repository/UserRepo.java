package com.pavansai.Springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavansai.Springsecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
