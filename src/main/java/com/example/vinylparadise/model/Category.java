package com.example.vinylparadise.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long categoryId;

    @Column
    @NotBlank
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Vinyl> vinyls = new HashSet<Vinyl>();

    public Category(){
        super();
    }
    public Category(@NotBlank Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category(@NotBlank Long categoryId, @NotBlank String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(@NotBlank String categoryName) {
        this.categoryName = categoryName;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(Set<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }
}
