package com.example.vinylparadise.controller;


import com.example.vinylparadise.model.UserOrder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @GetMapping()
    public ArrayList<UserOrder> getOrders (){
        return null;
        // returns all Orders (for Admin)
    }

    @GetMapping("/{orderId}")
    public UserOrder getOrder (@PathVariable int orderId){
        return null;
        // returns one specific Orders (for Admin)
    }

    @PostMapping()
    public void createOrder (@RequestBody @Valid UserOrder newUserOrder){
        // create new Order
    }

    @PutMapping("/{orderId}")
    public void updateOrder (@PathVariable @Valid int orderId){
        //  Update an Order
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder (@PathVariable int orderId){
        // Delete Order when order is ordered
    }






}
