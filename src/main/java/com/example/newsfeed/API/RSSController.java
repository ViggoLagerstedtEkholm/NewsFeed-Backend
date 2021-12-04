package com.example.newsfeed.API;

import com.example.newsfeed.Helpers.JWTHelper;
import com.example.newsfeed.Models.DTO.RSSUploadRequest;
import com.example.newsfeed.Models.DTO.RemoveUser;
import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.User;
import com.example.newsfeed.Service.RssService;
import com.example.newsfeed.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RSSController {
    private final RssService rssService;
    private final UserService userService;

    @PostMapping("/rss/add")
    public ResponseEntity<?> saveRSS(HttpServletRequest request, @RequestBody RSSUploadRequest rssRequest){
        String token = JWTHelper.getToken(request);
        String username = JWTHelper.getUsernameFromToken(token);

        User user = userService.getUser(username);

        RSS newRSS = new RSS();
        newRSS.setId(null);
        newRSS.setDisplayLimit(rssRequest.getDisplayLimit());
        newRSS.setUser(user);
        newRSS.setURL(rssRequest.getURL());

        rssService.saveRSS(newRSS);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rss/remove")
    public ResponseEntity<?> removeRSS(HttpServletRequest request, @RequestParam("rssID") Long id){
        String token = JWTHelper.getToken(request);
        String username = JWTHelper.getUsernameFromToken(token);

        //Check if user can delete...

        rssService.removeRSS(id);
        return ResponseEntity.ok().build();
    }
}
