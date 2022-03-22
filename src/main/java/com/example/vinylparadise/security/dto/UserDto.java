package com.example.vinylparadise.security.dto;

public class UserDto {

    public String lastname;
    public String firstName;
    public String email;
    public String userName;
    public String password;

    public UserDto(String lastname, String firstName, String email, String userName, String password) {
        this.lastname = lastname;
        this.firstName = firstName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
