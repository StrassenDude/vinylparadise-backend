package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Catagory;
import com.example.vinylparadise.model.Vinyl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/Vinyls")
public class VinylController {

    @GetMapping()
    public ArrayList<Vinyl> getVinyls(){
        return null;
        //returns all Vinyls
    }

    @GetMapping("/{artNr}")
    public Vinyl getVinyl(@PathVariable int artNr){
        return null;
    }

    @PostMapping()
    public void createVinyl (@RequestBody @Valid Vinyl newVinyl){
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
