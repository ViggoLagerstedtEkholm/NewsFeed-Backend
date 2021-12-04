package com.example.newsfeed.Models.DTO;

import lombok.Data;

@Data
public class ResetPassword {
    private String token;
    private String password;
}
