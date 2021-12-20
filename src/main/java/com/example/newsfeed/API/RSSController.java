package com.example.newsfeed.API;

import com.example.newsfeed.Helpers.JWTHelper;
import com.example.newsfeed.Models.DTO.Password;
import com.example.newsfeed.Models.DTO.RSSUploadRequest;
import com.example.newsfeed.Models.DTO.RemoveUser;
import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.User;
import com.example.newsfeed.Service.RssService;
import com.example.newsfeed.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RSSController {
    private final RssService rssService;
    private final UserService userService;

    @PostMapping("/rss/add")
    public ResponseEntity<?> saveRSS(HttpServletRequest request, RSSUploadRequest rssRequest){
        String token = JWTHelper.getToken(request);
        String username = JWTHelper.getUsernameFromToken(token);

        log.info("User found in the database {}", username);
        log.info("URL{}", rssRequest.getURL());
        log.info("LIMIT{}", rssRequest.getDisplayLimit());

        User user = userService.getUser(username);

        RSS newRSS = new RSS();
        newRSS.setId(null);
        newRSS.setDisplayLimit(rssRequest.getDisplayLimit());
        newRSS.setUser(user);
        newRSS.setURL(rssRequest.getURL());

        rssService.saveRSS(newRSS);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rss/get")
    public ResponseEntity<?> getRSS(HttpServletRequest request){
        String token = JWTHelper.getToken(request);
        String username = JWTHelper.getUsernameFromToken(token);

        User user = userService.getUser(username);
        log.info("User found in the database {}", user.getUsername());

        List<RSS> feeds = rssService.getAllRSSUser(user);

        return ResponseEntity.ok(feeds);
    }

    @PostMapping("/rss/remove")
    public ResponseEntity<?> removeRSS(HttpServletRequest request, @RequestParam("id") Long id){
        String token = JWTHelper.getToken(request);
        String username = JWTHelper.getUsernameFromToken(token);

        RSS rss = rssService.getRSS(id);
        if(rss == null){
            return ResponseEntity.notFound().build();
        }

        if(rss.getUser().getUsername().equals(username)){
            rssService.removeRSS(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
