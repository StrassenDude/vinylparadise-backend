package com.example.vinylparadise.security.service;

import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.responseModels.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserResponse> findUserById(long id) {
        if (id <= 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (userRepository.findByUserId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user with id: " + id + " doesn't exist!");
        } else {
            try {
                UserResponse userResponse = getUserResponse(userRepository.findByUserId(id));
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getCause());
            }
        }
    }

    public ResponseEntity<UserResponse> findUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The user with the username: " + username + " doesn't exist!");
        }
        try {
            UserResponse userResponse = getUserResponse(user);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getCause());
        }
    }




    public UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse(user.getFirstName(), user.getLastName(),
                user.getRole(), null);
        return userResponse;
    }

}
