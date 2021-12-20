package com.example.newsfeed.Service;

import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.User;
import com.example.newsfeed.Repositories.RSSRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RssServiceImplementation implements RssService {
    private final RSSRepository rssRepository;

    @Override
    public void saveRSS(RSS rss) {
        rssRepository.save(rss);
    }

    @Override
    public void removeRSS(Long id) {
        rssRepository.deleteById(id);
    }

    @Override
    public RSS getRSS(Long id) {
        return rssRepository.getById(id);
    }

    @Override
    public List<RSS> getAllRSSUser(User user) {
        return rssRepository.findAllByUserEquals(user);
    }
}
