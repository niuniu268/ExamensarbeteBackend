package org.example.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.config.PatternProperties;
import org.example.orderservice.pojo.Order;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PatternProperties properties;

    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format( DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @GetMapping("{id}")
    public void findById(@PathVariable Integer id){
        System.out.println(id );

        Order order = orderService.findById( id );
        System.out.println(order );
    }
}
