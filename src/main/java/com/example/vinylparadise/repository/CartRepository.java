package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByCartId (Long cartId);

}
