package org.example.orderservice.service;

import org.example.orderservice.pojo.Order;
import org.springframework.stereotype.Service;


public interface OrderService {
    Order findById(Integer id);
}
