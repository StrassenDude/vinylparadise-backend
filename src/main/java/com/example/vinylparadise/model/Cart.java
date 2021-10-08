package com.example.vinylparadise.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Vinyl> vinyls;

    @PositiveOrZero //ToDo: ist 0 in Positiv inkludiert??
    private int numberOfItemsCart;

    @PositiveOrZero
    @NotBlank
    private double PriceTotal;

    @Id
    private int cartId;

    public Cart() {
    }

    public Cart(ArrayList<Vinyl> vinyls, int numberOfItems, double priceTotal, int cartId) {
        this.vinyls = vinyls;
        this.numberOfItemsCart = numberOfItems;
        PriceTotal = priceTotal;
        this.cartId = cartId;
    }


    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(ArrayList<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }

    public int getNumberOfItemsCart() {
        return numberOfItemsCart;
    }

    public void setNumberOfItemsCart(int numberOfItemsCart) {
        this.numberOfItemsCart = numberOfItemsCart;
    }

    public double getPriceTotal() {
        return PriceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        PriceTotal = priceTotal;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
