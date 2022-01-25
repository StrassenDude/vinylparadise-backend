package com.example.vinylparadise.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;

@Entity
public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @NotBlank
    private String artist;

    @Positive
    private int tracks;

    @NotBlank
    private String category;




    //private ArrayList<Catagory> catagories;

    public Vinyl() {
    }

    public Vinyl(String name, double price, String artist, int tracks, String category) {
        //this.id = id;
        this.name = name;
        this.price = price;
        this.artist = artist;
        this.tracks = tracks;
        this.category = category;

        //this.catagories = catagories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    /*public ArrayList<Catagory> getCatagories() {
        return catagories;
    }

    public void setCatagories(ArrayList<Catagory> catagories) {
        this.catagories = catagories;
    }*/
}




