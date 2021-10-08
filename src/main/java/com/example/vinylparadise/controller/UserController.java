package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/User")
public class UserController {



    @GetMapping()
    public ArrayList<User> getUsers (){
        return null;
        // returns all Users (for Admin)
    }

    @GetMapping("/{userId}")
    public User getUser (@PathVariable int userId){
        return null;
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
