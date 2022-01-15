package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName); // TODO: 10.09.2021 findbyUsername?
    User findByUserId(long id);

}
