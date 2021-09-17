package com.example.vinylparadise.controller;

import com.example.vinylparadise.model.Cart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {


@GetMapping("/{userId}")
    public Cart getCart (@PathVariable int userId){
    return null;
    //gets user specific cart
}

@PostMapping()
    public void createNewCart (@RequestBody Cart newCart){
    // New cart created when logged in user is adds item
}

@PutMapping("/{userId}")
    public void updateCart (@PathVariable int userId){
    ///update cart ( add / remove / change amount)
}


}
