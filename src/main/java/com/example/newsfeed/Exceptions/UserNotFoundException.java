package com.example.newsfeed.Exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {}
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
