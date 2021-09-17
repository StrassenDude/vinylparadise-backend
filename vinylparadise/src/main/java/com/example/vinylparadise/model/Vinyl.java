package com.example.vinylparadise.model;

import java.util.ArrayList;

public class Vinyl {

    private String name;
    private double price;
    private String artist;
    private int tracks;
    private int artNr;
    private ArrayList<Catagory> catagories;

    public Vinyl() {
    }

    public Vinyl(String name, double price, String artist, int tracks, int artNr, ArrayList<Catagory> catagories) {
        this.name = name;
        this.price = price;
        this.artist = artist;
        this.tracks = tracks;
        this.artNr = artNr;
        this.catagories = catagories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }


    public int getArtNr() {
        return artNr;
    }

    public void setArtNr(int artNr) {
        this.artNr = artNr;
    }

    public ArrayList<Catagory> getCatagories() {
        return catagories;
    }

    public void setCatagories(ArrayList<Catagory> catagories) {
        this.catagories = catagories;
    }
}




