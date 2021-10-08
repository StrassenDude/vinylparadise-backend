package com.example.vinylparadise.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Vinyl> vinyls;

    @PositiveOrZero
    @NotBlank
    private int numberOfItemsAvailable;

    @NotBlank
    private boolean available;


    public Shop() {
    }

    public Shop(ArrayList<Vinyl> vinyls, int numberOfItemsAvailable, boolean available) {
        this.vinyls = vinyls;
        this.numberOfItemsAvailable = numberOfItemsAvailable;
        this.available = available;
    }

    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(ArrayList<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }

    public int getNumberOfItemsAvailable() {
        return numberOfItemsAvailable;
    }

    public void setNumberOfItemsAvailable(int numberOfItemsAvailable) {
        this.numberOfItemsAvailable = numberOfItemsAvailable;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
