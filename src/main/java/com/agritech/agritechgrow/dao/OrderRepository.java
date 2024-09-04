package com.agritech.agritechgrow.dao;

import java.util.List;

import com.agritech.agritechgrow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agritech.agritechgrow.entities.Order;

public interface OrderRepository extends JpaRepository<Order,String>{
    //@Query("select O from Order O where O.user.getUsername()=:user")
    public List<Order> findByUser(User user);
}
