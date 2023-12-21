package com.user.repositories;

import com.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String>
{
    //Custom finder method
    Optional<User> findByEmail(String email);
    List<User> findByNameContaining(String keywords);
}
