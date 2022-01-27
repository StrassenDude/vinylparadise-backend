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

    @PutMapping("/admin/vinyl/{id}")
    public Vinyl updateVinyl(@PathVariable @Valid Long id, @RequestBody @Valid Vinyl vinylDetails){
        Vinyl vinyl = vinylRepository.findVinylById(id);

        assert vinyl != null;
        vinyl.setName(vinylDetails.getName());
        vinyl.setPrice((vinylDetails.getPrice()));
        vinyl.setArtist(vinylDetails.getArtist());
        vinyl.setTracks(vinylDetails.getTracks());
        vinyl.setCategory(vinylDetails.getCategory());

        vinylRepository.save(vinyl);
        return vinyl;
    }


    @DeleteMapping("/{artNr}")
    public void deleteVinyl (@PathVariable int artNr){
        //delete Vinyl (admin only)
    }














}
