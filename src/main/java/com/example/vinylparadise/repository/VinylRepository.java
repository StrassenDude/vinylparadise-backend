package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.Vinyl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VinylRepository extends CrudRepository<Vinyl, Long> {
    Vinyl findVinylById(long id);
    Vinyl findVinylByName(String name);
}
