package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Cart;
import com.example.vinylparadise.model.CartItem;
import com.example.vinylparadise.model.User;
import com.example.vinylparadise.model.Vinyl;
import com.example.vinylparadise.repository.CartItemRepository;
import com.example.vinylparadise.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private VinylController vinylController;

    @Autowired
    private UserController userController;


    @GetMapping("/cart/{cartId}")
    public Cart getCartById(@PathVariable Long cartId){
        return cartRepository.findByCartId(cartId);
    }

    @GetMapping("/cartItems")
    public Iterable<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    @GetMapping("/cartItems/{userId}")
    public Iterable<CartItem> getAllItems(@PathVariable Long userId){
        return cartItemRepository.findByUser(userId);
    }

    @PostMapping("/user/cartItem/add/{vinylId}/{userId}/{cartId}")
    public  Cart createItem (@PathVariable Long vinylId,
                             @PathVariable Long userId,
                             @PathVariable Long cartId
    ){
        User user = userController.getUserById(userId);
        Vinyl vinyl = vinylController.getVinylById(vinylId);

        Cart cart = getCartById(cartId);

        CartItem newItem = new CartItem(cart,vinyl,user);

        cartItemRepository.save(newItem);


        List<CartItem> currentCart = cart.getCartItems();

        currentCart.add(newItem);


        cart.setCartItems(currentCart);

        cartRepository.save(cart);


        return cart;

    }


    public List<Vinyl> getAllVinyls(List<CartItem> itemsAlreadyExist) {
        List<Vinyl> vinyls = new ArrayList<>();
        for (CartItem cartItem : itemsAlreadyExist) {
            Vinyl vinyl = cartItem.getVinyl();
            vinyls.add(vinyl);
        }
        return vinyls;
    }



}
