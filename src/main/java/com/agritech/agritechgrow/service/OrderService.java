package com.agritech.agritechgrow.service;

import java.util.List;

import com.agritech.agritechgrow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agritech.agritechgrow.dao.OrderRepository;
import com.agritech.agritechgrow.entities.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getOrdersByUsername(User user){
        return orderRepository.findByUser(user);
    }
}
