package com.example.vinylparadise.model;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Vinyl> vinyls;
    private int numberOfItemsAvailable;
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
