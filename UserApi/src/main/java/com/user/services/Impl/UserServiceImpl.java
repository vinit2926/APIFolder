package com.user.services.Impl;

import com.user.entities.User;
import com.user.repositories.UserRepository;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user)
    {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User updateUser(String userId, User user)
    {
        User u = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found By This Id"));
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAbout(user.getAbout());

        User updatedUser = userRepository.save(u);
        return updatedUser;
    }

    @Override
    public void deleteUser(String userId)
    {
      User u = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found By This Id"));
      userRepository.delete(u);
    }

    @Override
    public List<User> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getSingleUserById(String userId)
    {
        User u = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found By This Id"));
        return u;
    }

    @Override
    public User getSingleUserByEmail(String email)
    {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found By This Email"));
        return user;
    }

    @Override
    public List<User> searchUser(String keyword)
    {
        List<User> listOfNames = userRepository.findByNameContaining(keyword);
        return listOfNames;
    }
}
