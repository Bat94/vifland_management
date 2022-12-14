package com.example.postviflandmanagement.repository;

import com.example.postviflandmanagement.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
