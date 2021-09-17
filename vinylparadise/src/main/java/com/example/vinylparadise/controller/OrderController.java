package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.Order;
import com.example.vinylparadise.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping()
    public ArrayList<Order> getOrders (){
        return null;
        // returns all Orders (for Admin)
    }

    @GetMapping("/{orderId}")
    public Order getOrder (@PathVariable int orderId){
        return null;
        // returns one specific Orders (for Admin)
    }

    @PostMapping()
    public void createOrder (@RequestBody Order newOrder){
        // create new Order
    }

    @PutMapping("/{orderId}")
    public void updateOrder (@PathVariable int orderId){
        //  Update an Order
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder (@PathVariable int orderId){
        // Delete Order when order is ordered
    }






}
