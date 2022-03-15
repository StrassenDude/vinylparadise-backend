package com.example.vinylparadise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User {

    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Id
    private long userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    //@JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "ROLE_USER"; // TODO: 10.09.2021 get&set gebraucht?

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;



    public User() {
    }

    public User(String firstName, String lastName, String email, String userName, String password) { // TODO: 10.09.2021 Builder machen
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
