package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);

    List<User> findAll();

    User findByUserId(Long id);

    User findByEmail(String email);
}