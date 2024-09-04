package com.agritech.agritechgrow.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agritech.agritechgrow.entities.Product;

public interface ProductRepository extends JpaRepository<Product,String>{
 
}
