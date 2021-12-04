package com.example.newsfeed;

import com.example.newsfeed.Models.Persistance.RSS;
import com.example.newsfeed.Models.Persistance.Role;
import com.example.newsfeed.Models.Persistance.User;
import com.example.newsfeed.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Set;

@SpringBootApplication
public class NewsFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return arg -> {
            //userService.saveRole(new Role(null, "ROLE_STANDARD"));

            //User user1 = new User(null, "Email1", "firstname1", "lastname1", "username1", "field1", new ArrayList<>(), null);
            //User user2 = new User(null, "Email2", "firstname2", "lastname2", "username2", "field2", new ArrayList<>(), null);

            //userService.saveUser(user1);
            //userService.saveUser(user2);

            //for(User user : userService.getAllUsers()) {
             //   userService.addRoleToUser(user.getUsername(), "ROLE_STANDARD");
           // }
        };
    }
}
