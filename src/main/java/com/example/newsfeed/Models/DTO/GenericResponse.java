package com.example.newsfeed.Models.DTO;

import lombok.Data;

@Data
public class GenericResponse {
    private String message;
    private String error;

    public GenericResponse(final String message) {
        super();
        this.message = message;
    }
}
