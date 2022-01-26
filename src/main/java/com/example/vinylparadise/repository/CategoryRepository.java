package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByCategoryName(String categoryName);

}
