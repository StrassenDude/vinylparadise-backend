package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.User;
import com.example.vinylparadise.responseModels.UserResponse;
import com.example.vinylparadise.security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ArrayList<User> getUsers (){
        return null;
        // returns all Users (for Admin)
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId){
        return userService.findUserById(userId);
        // returns one specific User (for Admin)
    }

    @PostMapping()
    public void createUser (@RequestBody @Valid User newUser){
        // create new User
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
