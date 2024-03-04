package org.example.orderservice.controller;

import org.example.orderservice.pojo.Order;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("{id}")
    public void findById(@PathVariable Integer id){
        System.out.println(id );

        Order order = orderService.findById( id );
        System.out.println(order );
    }
}
