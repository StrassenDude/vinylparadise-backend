package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Category;
import com.example.vinylparadise.model.Vinyl;
import com.example.vinylparadise.repository.CategoryRepository;
import com.example.vinylparadise.repository.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
//@RequestMapping("/vinyls")
@CrossOrigin(origins = "http://localhost:8080")
public class VinylController {


    @Autowired
    private VinylRepository vinylRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public VinylController(VinylRepository vinylRepository) {
        this.vinylRepository = vinylRepository;
    }

    @GetMapping("/vinyls")
    public Iterable<Vinyl> getAllVinyls(){
        return this.vinylRepository.findAll();
        //returns all Vinyls
    }

    @GetMapping("/vinyls/id/{id}")
    public Vinyl getVinylById(@PathVariable Long id){
        return vinylRepository.findVinylById(id);
    }

    @GetMapping("/vinyls/name/{name}")
    public Vinyl getVinylByName(@PathVariable String name){
        return vinylRepository.findVinylByName(name);
    }

    @GetMapping("/vinyls/category/{categoryName}")
    public Iterable<Vinyl> getVinylsByCategory(@PathVariable String categoryName){
        return vinylRepository.findByCategory(categoryName);
    }

    @PostMapping("/admin/vinyls/add")
    public @ResponseBody Vinyl createVinyl (@RequestBody @Valid Vinyl newVinyl)
    {

        vinylRepository.save(newVinyl);
        return newVinyl;

        //create new Vinyl (Admin only)
    }


    // assign product to category by id
    @PutMapping("/admin/categories/id/{categoryId}/vinyls/{id}")
    public Vinyl assignVinyltoCategory(@PathVariable Long id, @PathVariable Long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        Vinyl vinyl = vinylRepository.findVinylById(id);

        assert vinyl != null;
        vinyl.setCategory(category);
        return vinylRepository.save(vinyl);
    }

    // assign product to category by name
    @PutMapping("/admin/categories/assign/{categoryName}/{name}")
    public Vinyl assignVinyltoCategory(@PathVariable String name, @PathVariable String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        Vinyl vinyl = vinylRepository.findVinylByName(name);

        assert vinyl != null;
        vinyl.setCategory(category);
        System.out.println(vinyl);
        return vinylRepository.save(vinyl);
    }


    @DeleteMapping("/{artNr}")
    public void deleteVinyl (@PathVariable int artNr){
        //delete Vinyl (admin only)
    }


    @GetMapping("/{vinylId}")
    public ArrayList<Category> getVinylCategories(@PathVariable int vinylId){
        return null;
        // returns all categories of one vinyl
    }













}
