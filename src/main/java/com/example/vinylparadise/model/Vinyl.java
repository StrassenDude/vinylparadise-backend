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
    @Column(nullable = false)
    private String name;

    @Positive
    @Column(nullable = false)
    private double price;

    @NotBlank
    @Column(nullable = false)
    private String artist;

    @Positive
    @Column(nullable = false)
    private int tracks;


    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;



    public Vinyl() {
    }

    public Vinyl(String name, double price, String artist, int tracks, Category category) {
        //this.id = id;
        this.name = name;
        this.price = price;
        this.artist = artist;
        this.tracks = tracks;
        this.category = category;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    @Override
    public String toString() {
        return "Vinyl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", category=" + category +
                '}';
    }

}




