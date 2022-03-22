package com.example.vinylparadise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    @Column
    private String imgRef;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vinyl", cascade = CascadeType.PERSIST)
    private Set<CartItem> cartItem = new HashSet<CartItem>();

    public Vinyl() {
        super();
    }

    public Vinyl(String name, double price, String artist, int tracks,String imgRef, Category category) {
        this.name = name;
        this.price = price;
        this.artist = artist;
        this.tracks = tracks;
        this.imgRef = imgRef;
        this.category = category;
    }

    public String getImgRef() {
        return imgRef;
    }

    public void setImgRef(String imgRef) {
        this.imgRef = imgRef;
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
                '}';
    }
}