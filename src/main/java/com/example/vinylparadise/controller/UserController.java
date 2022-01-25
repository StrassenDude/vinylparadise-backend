package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.responseModels.UserResponse;
import com.example.vinylparadise.security.dto.UserDto;
import com.example.vinylparadise.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
//@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById (@PathVariable Long userId){
        return userRepository.findById(userId);
    }

    @GetMapping("/user")
    public Iterable<User> getAllRegisteredUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<UserResponse> getUserbyUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }


    @PostMapping(path = "/registration")
    public @ResponseBody User createUser(@RequestBody @Valid User user) {
        userRepository.save(user);


        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        return user;
    }

    @PutMapping("/{userId}")
    public void updateUser (@PathVariable @Valid int userId){
        //  Update User
    }

    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable int userId){
        // Delete User
    }

}
