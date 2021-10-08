package com.example.vinylparadise.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class Catagory {

    @Id
    private int id;

    @NotBlank
    private String name;

    private ArrayList<Vinyl> vinyls;


    public Catagory() {
    }

    public Catagory(int id, String name, ArrayList<Vinyl> vinyls) {
        this.id = id;
        this.name = name;
        this.vinyls = vinyls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(ArrayList<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }
}
