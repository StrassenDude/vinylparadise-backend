package com.example.vinylparadise.repository;

import com.example.vinylparadise.model.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<UserOrder, Long> {

}
