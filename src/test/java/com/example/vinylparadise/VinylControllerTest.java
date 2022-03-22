package com.example.vinylparadise;


import com.example.vinylparadise.controller.VinylController;
import com.example.vinylparadise.model.Category;
import com.example.vinylparadise.model.Vinyl;
import com.example.vinylparadise.repository.VinylRepository;
import com.example.vinylparadise.security.dto.UserDto;
import com.example.vinylparadise.security.dto.VinylDto;
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
public class VinylControllerTest {

    @Autowired
    private VinylController vinylController;

    @Autowired
    private VinylRepository vinylRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init(){
        Category TestHop = new Category(45L,"TestHop");
        Category TestJazz = new Category(60L,"TestJazz");

        Vinyl vinyl = new Vinyl("name",20,"GulliverGoogs",17,"http://localhost:8080/api/downloadFile/firstCommanderFF.jpeg",TestHop);
        //UserDto userDto = new UserDto("lastName","firstName","first.last@email.com","User1","12346");
        //userService.saveUser(userDto);

        vinylRepository.save(vinyl);
    }

    @Test
    public void findAllVinyls(){
        List<Vinyl> vinyls = (List<Vinyl>) vinylRepository.findAll();
        vinyls.get(0).getArtist().equalsIgnoreCase("21 Savage");
    }

    @Test
    public void deleteVinyl(){
        Vinyl vinyl1 = vinylRepository.findVinylByName("name");
        vinylRepository.delete(vinyl1);
        vinyl1 = vinylRepository.findVinylByName("name");
        assertNull(vinyl1);
    }
}
