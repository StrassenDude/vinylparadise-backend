package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Category;
import com.example.vinylparadise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequestMapping("/catagories")
@CrossOrigin(origins = "http://localhost:8080")
public class CatagoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/categories")
    public Iterable<Category> getAllCatagories(){
        return categoryRepository.findAll();
        // returns a List of all catagories available
    }


    @GetMapping("/categories/{categoryName}")
    public Category getCatagories(@PathVariable String categoryName ){
        return categoryRepository.findByCategoryName(categoryName);
        // returns one spezific Category
    }

    @PostMapping("/admin/categories/add")
    public @ResponseBody Category createCatagory (@RequestBody @Valid Category newCatagory){
        categoryRepository.save(newCatagory);
        System.out.println(newCatagory);

        return newCatagory;
        // create new Catagory
    }

    @PutMapping("/{catagoryId}")
    public void updateCatagory (@PathVariable @Valid int catagoryId){
        //  Update an Catagory
    }

    @DeleteMapping("/{catagoryId}")
    public void deleteCatagory (@PathVariable int catagoryId){
        // Delete Catagory
    }







}
