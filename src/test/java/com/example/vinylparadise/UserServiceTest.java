package com.example.vinylparadise;

import com.example.vinylparadise.model.User;
import com.example.vinylparadise.repository.UserRepository;
import com.example.vinylparadise.security.dto.UserDto;
import com.example.vinylparadise.security.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init(){
        UserDto userDto1 = new UserDto("Last1","First1","first.last@email.com","User1","12345");
        UserDto userDto2 = new UserDto("Last2","First2","second.last@email.com","User2","12345");
        UserDto userDto3 = new UserDto("Last3","First3","third.last@email.com","User3","12345");

        userService.saveUser(userDto1);
        userService.saveUser(userDto2);
        userService.saveUser(userDto3);
        }

        //dh2 in memory DB

    @Test
    public void findAllUsers(){
        List<User> users = userRepository.findAll();
        User user = userRepository.findByUserName("User1");
        User user2 = userRepository.findByUserName("User2");

        assertTrue(users.get(1).getUserName().equalsIgnoreCase("User1"));
        assertTrue(users.get(2).getUserName().equalsIgnoreCase("user2"));
        assertTrue(users.get(3).getUserName().equalsIgnoreCase("user3"));

        assertTrue(user.getEmail().equalsIgnoreCase("first.last@email.com"));
        assertTrue(user2.getFirstName().equalsIgnoreCase("First2"));
    }

    @Test
    void updateUser() {
        UserDto userDtoUpdate = new UserDto("LastName","FirstName", "updatedEmail.mail@email.com", "User1","123456");
        userService.updateUser("User1",userDtoUpdate);
        User user = userRepository.findByUserName("User1");
        assertFalse(user.getEmail().equalsIgnoreCase("first.last@email.com"));
        assertTrue(user.getFirstName().equalsIgnoreCase("FirstName"));
    }

    @Test
    public void setGetRoles(){
        User user = userRepository.findByUserName("User1");
        User user2 = userRepository.findByUserName("User2");

        assertTrue(user.getRole() == "ROLE_USER");
        user.setRole("ROLE_ADMIN");
        user.setRole("ROLE_USER");
        assertTrue(user.getRole() == "ROLE_ADMIN");
        assertTrue(user2.getRole() == "ROLE_USER");
    }

    @Test
    public void deleteUser(){
        User user = userRepository.findByUserName("User2");
        userRepository.delete(user);
        user = userRepository.findByUserName("User2");
        assertNull(user);
    }
}
