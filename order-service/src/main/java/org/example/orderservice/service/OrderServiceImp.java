package org.example.orderservice.service;

import org.example.orderservice.mapper.OrderMapper;
import org.example.orderservice.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order findById (Integer id) {
        return orderMapper.findById( id );
    }
}
