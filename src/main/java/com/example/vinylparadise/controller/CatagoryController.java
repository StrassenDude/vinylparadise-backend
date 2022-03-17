package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Category;
import com.example.vinylparadise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8080")
public class CatagoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/categories")
    public Iterable<Category> getAllCatagories(){
        return categoryRepository.findAll();
        // returns a List of all catagories available
    }


    @GetMapping("/categories/categoryName/{categoryName}")
    public Category getCatagoriesbyCategoryName(@PathVariable String categoryName ){
        return categoryRepository.findByCategoryName(categoryName);
        // returns one spezific Category by name
    }

    @GetMapping("/categories/categoryId/{categoryId}")
    public Category getCategoriesByCategoryId(@PathVariable Long categoryId ){
        return categoryRepository.findByCategoryId(categoryId);
        // returns one spezific Category by id
    }

    @PostMapping("/admin/categories/add")
    public @ResponseBody Category createCatagory (@RequestBody @Valid Category newCatagory){
        categoryRepository.save(newCatagory);
        return newCatagory;
        // create new Catagory
    }

    @PutMapping("/admin/categories/{catagoryId}")
    public void updateCatagory (@PathVariable @Valid Long catagoryId, @Valid @RequestBody Category categoryDetails){
        Category category = categoryRepository.findByCategoryId(catagoryId);

        assert category != null;
        category.setCategoryName(categoryDetails.getCategoryName());
        //  Update an Catagory
    }

    @DeleteMapping("/admin/categories/{catagoryId}") // Delete Catagory
    public String deleteCatagory (@PathVariable Long catagoryId){

        categoryRepository.deleteById(catagoryId);
        return "Category" + catagoryId + " was deleted";


    }







}
