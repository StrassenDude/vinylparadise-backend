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

    @GetMapping("/user/id/{userId}") //find User by Id
    public Optional<User> getUserById (@PathVariable Long userId){
        return userRepository.findById(userId);
    }

    @GetMapping("/user/userName/{userName}") //find User by userName
    public User getUserByUserName (@PathVariable String userName){
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/user") //find all Users
    public Iterable<User> getAllRegisteredUser() {
        return userRepository.findAll();
    }


    @PostMapping(path = "/registration")
    public @ResponseBody User createUser(@RequestBody @Valid User user) {

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return user;
    }

    @PutMapping("/user/{userId}")
    public User updateUser (@PathVariable @Valid int userId, @Valid @RequestBody User userDetails){
        User user = userRepository.findByUserId(userId);

        assert user !=null;
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        user.setGebDat(userDetails.getGebDat());
        user.setRole(userDetails.getRole());
        userRepository.save(user);
        return user;


        //  Update User
    }

    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable int userId){
        // Delete User
    }

}
