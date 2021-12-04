package com.example.newsfeed.Repositories;

import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RSSRepository extends JpaRepository<RSS, Long> {
    List<RSS> findAllByUserEquals(User user);
}
