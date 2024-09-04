package com.agritech.agritechgrow.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {


    @Id
    private String product_name;
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    @Override
    public String toString() {
        return "Order [product_name=" + product_name + ", cost=" + cost + ", product_image=" + product_image
                + ", quantity=" + quantity + ", user=" + user + "]";
    }
    public Order(String product_name, double cost, String product_image, int quantity, User user) {
        this.product_name = product_name;
        this.cost = cost;
        this.product_image = product_image;
        this.quantity = quantity;
        this.user = user;
    }
    public double getCost() {
        return cost;
    }
    public Order() {
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getProduct_image() {
        return product_image;
    }
    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private double cost;
    private String product_image;
    private int quantity;
    @ManyToOne
    private User user;
    
}
