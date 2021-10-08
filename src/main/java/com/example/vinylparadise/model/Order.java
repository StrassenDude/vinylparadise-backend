package com.example.vinylparadise.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Date;

public class Order {
     private ArrayList<Vinyl> vinyls;

     @NotBlank
     @Positive
     private int numberOfItemsOrdered;

     @NotBlank
     @Positive
     private double priceTotal;

     @NotBlank
     private Date orderDate;

     @Id
     private int orderId;


    public Order() {
    }

    public Order(ArrayList<Vinyl> vinyls, int numberOfItemsOrdered, double priceTotal, Date orderDate, int orderId) {
        this.vinyls = vinyls;
        this.numberOfItemsOrdered = numberOfItemsOrdered;
        this.priceTotal = priceTotal;
        this.orderDate = orderDate;
        this.orderId = orderId;
    }


    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(ArrayList<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }

    public int getNumberOfItemsOrdered() {
        return numberOfItemsOrdered;
    }

    public void setNumberOfItemsOrdered(int numberOfItemsOrdered) {
        this.numberOfItemsOrdered = numberOfItemsOrdered;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
