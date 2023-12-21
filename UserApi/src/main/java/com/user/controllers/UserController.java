package com.user.controllers;


import com.user.entities.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

     @Autowired
     UserService userService;

    //create
    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user)
    {
        User u = userService.createUser(user);
       return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{userId}")
    ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userId") String userId)
    {
        User user1 = userService.updateUser(userId, user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable String userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User is deleted",HttpStatus.OK);
    }


    //get all users
    @GetMapping
    ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    //get single user by id
    @GetMapping("single/{userId}")
    ResponseEntity<User> getSingleUserById(@PathVariable String userId)
    {
        return new ResponseEntity<>(userService.getSingleUserById(userId),HttpStatus.OK);
    }

    //get single user by email
    @GetMapping("email/{userEmail}")
    ResponseEntity<User> getSingleUserByEmail(@PathVariable String userEmail)
    {
        return new ResponseEntity<>(userService.getSingleUserByEmail(userEmail),HttpStatus.OK);
    }

    //search user
    @GetMapping("search/{keyword}")
    ResponseEntity<List<User>> getUserByKeyword(@PathVariable String keyword) {
        return new ResponseEntity<>(userService.searchUser(keyword), HttpStatus.OK);
    }
}
