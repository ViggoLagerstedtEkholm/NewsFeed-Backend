package com.example.newsfeed.Models.DTO;

import lombok.Data;

@Data
public class RSSUploadRequest {
    private String URL;
    private int displayLimit;
}
