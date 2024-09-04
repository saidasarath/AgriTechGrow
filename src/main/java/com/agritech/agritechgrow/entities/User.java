package com.agritech.agritechgrow.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    public User(String username, String name, String password, String mobile, String email, String role, String image,
            List<Order> orders) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.role = role;
        this.image = image;
        this.orders = orders;
    }

    @Id
    private String username;
    private String name;
    private String password;
    private String mobile;
    private String email;
    private String role;
    private String image;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private List<Order> orders;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

  
}
