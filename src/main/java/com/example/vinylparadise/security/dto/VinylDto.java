package com.example.vinylparadise.security.dto;

import com.example.vinylparadise.model.Category;

public class VinylDto {

    public String name;
    public Double price;
    public String artist;
    public Integer tracks;
    public String imgRef;
    public Category cat;

    public VinylDto(String name, Double price, String artist, Integer tracks, String imgRef, Category cat) {
        this.name = name;
        this.price = price;
        this.artist = artist;
        this.tracks = tracks;
        this.imgRef = imgRef;
        this.cat = cat;
    }
}
