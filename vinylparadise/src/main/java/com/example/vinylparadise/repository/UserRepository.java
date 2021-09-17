package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName); // TODO: 10.09.2021 findbyUsername?
}
