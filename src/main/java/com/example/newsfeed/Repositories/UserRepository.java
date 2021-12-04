package com.example.newsfeed.Repositories;

import com.example.newsfeed.Models.Persistance.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByOrderByIdAsc();
    List<User> findAllByUsername(Sort by, String username);
    User findUserByEmail(String email);
}
