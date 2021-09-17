package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Catagory;
import com.example.vinylparadise.model.Vinyl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/catagories")
public class CatagoryController {


    @GetMapping()
    public ArrayList<Catagory> catagories(){
        return null;
        // returns a List of all catagories available
    }


    @GetMapping("/{catagoryId}")
    public ArrayList<Vinyl> getCatagories(@PathVariable int catagoryId ){
        return null;
        // returns all vinyls of one Catagory
    }

    @PostMapping()
    public void createCatagory (@RequestBody Catagory catagory){
        // create new Catagory
    }

    @PutMapping("/{catagoryId}")
    public void updateCatagory (@PathVariable int catagoryId){
        //  Update an Catagory
    }

    @DeleteMapping("/{catagoryId}")
    public void deleteCatagory (@PathVariable int catagoryId){
        // Delete Catagory
    }







}
