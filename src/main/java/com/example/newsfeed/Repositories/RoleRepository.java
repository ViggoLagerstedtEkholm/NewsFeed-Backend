package com.example.newsfeed.Repositories;

import com.example.newsfeed.Models.Persistance.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}
