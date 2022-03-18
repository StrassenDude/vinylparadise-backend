package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.CartItem;
import com.example.vinylparadise.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    Iterable<CartItem> findByUser(Long userId);
    CartItem findByCartItemId(Long itemId);

}
