package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Cart;
import com.example.vinylparadise.model.CartItem;
import com.example.vinylparadise.model.User;
import com.example.vinylparadise.model.Vinyl;
import com.example.vinylparadise.repository.CartItemRepository;
import com.example.vinylparadise.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @GetMapping("/cartItem/{cartItemId}")
    public CartItem getCartItemById (@PathVariable Long cartItemId){
        return cartItemRepository.findByCartItemId(cartItemId);
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

        List<CartItem> currentCart = cart.getCartItems();
        List<Vinyl> currentVinyls = getAllVinyls(currentCart);

        List<CartItem> newList = new ArrayList<>();


        if(currentCart.size() == 0) {
            CartItem newItem = new CartItem(cart, vinyl, user);
            cartItemRepository.save(newItem);
            currentCart.add(newItem);
            cart.setCartItems(currentCart);
            cartRepository.save(cart);
        }
        else{
            CartItem newItem = new CartItem(cart, vinyl, user);

            if(!currentVinyls.contains(vinyl)){
                cartItemRepository.save(newItem);
                currentCart.add(newItem);
                cart.setCartItems(currentCart);
                cartRepository.save(cart);
            }
            else{
                for(CartItem cartItem : currentCart){
                    if(cartItem.getVinyl() == vinyl){
                        cartItem.setQuantity(cartItem.getQuantity() + 1);
                        cartItemRepository.save(cartItem);
                        cart.setCartItems(currentCart);
                        cartRepository.save(cart);
                    }
                }
            }

        }
        return cart;
    }

    @PutMapping("/user/updateQuantity/{cartItemId}/{newQuantity}")
    public void updateQuantity(@PathVariable Long cartItemId, @PathVariable int newQuantity){
        CartItem cartItem = cartItemRepository.findByCartItemId(cartItemId);
        cartItem.setQuantity(newQuantity);
        cartItemRepository.save(cartItem);
    }

    @DeleteMapping("/user/deleteCartItem/{itemId}")
    public void deleteCartItem(@PathVariable Long itemId){
        CartItem cartItem = cartItemRepository.findByCartItemId(itemId);
        cartItemRepository.delete(cartItem);
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
