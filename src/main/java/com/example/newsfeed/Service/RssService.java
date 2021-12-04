package com.example.newsfeed.Service;

import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.User;

import java.util.List;

public interface RssService {
    void saveRSS(RSS rss);
    void removeRSS(Long rss);
    RSS getRSS(Long id);
    List<RSS> getAllRSSByUsername(User user);
}
