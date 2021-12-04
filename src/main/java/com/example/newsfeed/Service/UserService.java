package com.example.newsfeed.Service;

import com.example.newsfeed.Models.Persistance.Role;
import com.example.newsfeed.Models.Persistance.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    void deleteUser(User user);
    User findUserByEmail(String email);
    void createPasswordResetTokenForUser(User user, String token);
    User getUserByPasswordResetToken(String token);
    String validatePasswordResetToken(String token);
    List<User> getAllUsers();
    List<User> getAllUsersByUsername(String search);
}
