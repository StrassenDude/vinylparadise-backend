package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Catagory;
import com.example.vinylparadise.model.Vinyl;
import com.example.vinylparadise.repository.VinylRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/vinyls")
@CrossOrigin(origins = "http://localhost:8080")
public class VinylController {


    @Autowired
    private VinylRepository vinylRepository;

    public VinylController(VinylRepository vinylRepository) {
        this.vinylRepository = vinylRepository;
    }

    @GetMapping("/vinyls")
    public Iterable<Vinyl> getAllVinyls(){
        return this.vinylRepository.findAll();
        //returns all Vinyls
    }

    @GetMapping("/vinyls/{id}")
    public Vinyl getVinylById(@PathVariable Long id){
        return vinylRepository.findVinylById(id);
    }

    @PostMapping("/upload")
    public @ResponseBody Vinyl createVinyl (@RequestBody @Valid Vinyl newVinyl){
        vinylRepository.save(newVinyl);

        return newVinyl;
        //create new Vinyl (Admin only)
    }

    @PutMapping("/{artNr}")
    public void updateVinyl (@PathVariable @Valid int artNr){
        //Update vinyl (admin only)
    }

    @DeleteMapping("/{artNr}")
    public void deleteVinyl (@PathVariable int artNr){
        //delete Vinyl (admin only)
    }


    @GetMapping("/{vinylId}")
    public ArrayList<Catagory> getVinylCategories(@PathVariable int vinylId){
        return null;
        // returns all categories of one vinyl
    }













}
