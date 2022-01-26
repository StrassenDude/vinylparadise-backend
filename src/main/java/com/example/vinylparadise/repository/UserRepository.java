package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
    List<User> findAll();
    User findByUserId(long id);

    User findByEmail (String email);

    User findUserByEmail(String email);

}
