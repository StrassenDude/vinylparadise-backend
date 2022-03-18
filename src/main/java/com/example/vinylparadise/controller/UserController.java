package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.responseModels.UserResponse;
import com.example.vinylparadise.security.dto.UserDto;
import com.example.vinylparadise.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/user") //find all Users
    public Iterable<User> getAllRegisteredUser() {
        return userRepository.findAll();
    }

    @GetMapping("/user/id/{userId}") //find User by Id
    public User getUserById (@PathVariable Long userId){
        return userRepository.findByUserId(userId);
    }

    @GetMapping("/user/userName/{userName}") //find User by userName
    public User getUserByUserName (@PathVariable String userName){
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/user/email/{email}") //find User by email
    public User getUserbyEmail (@PathVariable @Valid String email){
        return userRepository.findByEmail(email);
    }

    @GetMapping("/user/role")
    public Collection<? extends GrantedAuthority> getCurrentAuthorities() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities();
    }

    @RequestMapping(value = "/user/userName", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        System.out.println(authentication.getName());
        return authentication.getName();
    }

    @PostMapping(path = "/registration")
    public @ResponseBody User createUser(@RequestBody @Valid User user) {

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);
        System.out.println(user);

        return user;
    }

    @PutMapping("/user/{userId}")
    public User updateUser (@PathVariable @Valid int userId, @Valid @RequestBody User userDetails){
        User user = userRepository.findByUserId(userId);

        assert user !=null;
        user.setUserName(userDetails.getUserName());
        String encodedPassword = bCryptPasswordEncoder.encode(userDetails.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        userRepository.save(user);
        return user;


        //  Update User
    }

    @DeleteMapping("/admin/deleteUser/{userName}")         // Delete User
    public void deleteUser (@PathVariable @Valid String userName){
        User user = userRepository.findByUserName(userName);

        userRepository.delete(user);

    }

}
