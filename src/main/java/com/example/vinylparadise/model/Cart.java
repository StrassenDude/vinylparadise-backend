package com.example.vinylparadise.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartId;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.PERSIST)
    private List<CartItem> cartItems = new ArrayList<>();



    public Cart(Long cartId, List<CartItem> cartItems) {
        super();
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public Cart(List<CartItem> cartItems) {
        super();
        this.cartItems = cartItems;
    }

    public Cart(){
        super();
    };

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
