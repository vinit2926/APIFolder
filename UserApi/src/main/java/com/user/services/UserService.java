package com.user.services;

import com.user.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService
{
    //create
    User createUser(User user);

    //update
    User updateUser(String userId,User user);

    //delete
    void deleteUser(String userId);

    //get all users
    List<User> getAllUsers();

    //get single user by id
    User getSingleUserById(String userId);

    //get single user by email
    User getSingleUserByEmail(String email);

    //search user
    List<User> searchUser(String keyword);
}
