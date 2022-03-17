package com.example.vinylparadise.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartItemId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Vinyl vinyl;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Positive
    @Column(nullable = false)
    private int quantity = 1;

    public CartItem(Cart cart, Vinyl vinyl, User user) {
        super();
        this.cart = cart;
        this.vinyl = vinyl;
        this.user = user;
    }

    public CartItem(Cart cart, Vinyl vinyl, User user, int quantity) {
        super();
        this.cart = cart;
        this.vinyl = vinyl;
        this.user = user;
        this.quantity = quantity;
    }

    public CartItem(Vinyl vinyl, User user, int quantity) {
        super();
        this.vinyl = vinyl;
        this.user = user;
        this.quantity = quantity;
    }

    public CartItem() {
        super();
    }

    public CartItem(Vinyl vinyl, User user) {
        super();
        this.vinyl = vinyl;
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Vinyl getVinyl() {
        return vinyl;
    }

    public void setVinyl(Vinyl vinyl) {
        this.vinyl = vinyl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", vinyl=" + vinyl +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
