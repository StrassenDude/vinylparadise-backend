package com.example.vinylparadise.security.service;

import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.responseModels.UserResponse;
import com.example.vinylparadise.security.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    // FIXME find user by username for save and update
    public ResponseEntity<UserResponse> saveUser(UserDto userDto) {

        if (userDto.email == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (userDto.lastname == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (userDto.firstName == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (userDto.userName == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (userDto.password == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        } else {
            try {
                User user = new User();
                user.setEmail(userDto.email);
                user.setLastName(userDto.lastname);
                user.setFirstName(userDto.firstName);
                user.setUserName(userDto.userName);
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(userDto.password);
                user.setPassword(encodedPassword);
                userRepository.save(user);
                UserResponse userResponse = getUserResponse(user);
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
        return new UserResponse(user.getFirstName(), user.getLastName(),
                user.getRole(), null);
    }

}
