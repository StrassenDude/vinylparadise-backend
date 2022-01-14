package com.example.vinylparadise.model;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class UserOrder {

    //private ArrayList<Vinyl> vinyls;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
     private int numberOfItemsOrdered;

     @NotBlank
     private double priceTotal;

     @NotBlank
     private Date orderDate;



    public UserOrder() {
    }

    public UserOrder(ArrayList<Vinyl> vinyls, int numberOfItemsOrdered, double priceTotal, Date orderDate, int orderId) {
        //this.vinyls = vinyls;
        this.numberOfItemsOrdered = numberOfItemsOrdered;
        this.priceTotal = priceTotal;
        this.orderDate = orderDate;
    }


    /*

    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(ArrayList<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }

     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
