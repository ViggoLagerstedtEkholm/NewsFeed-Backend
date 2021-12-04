package com.example.newsfeed.Models.DTO;

import lombok.Data;

@Data
public class UserResponse {
    private String username;
    private String firstname;
    private String lastname;
    private Long id;

    public UserResponse(String username, String firstname, String lastname, Long id) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }
}
