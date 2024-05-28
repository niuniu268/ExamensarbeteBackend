package org.example.orderservice.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.config.PatternProperties;
import org.example.orderservice.pojo.Order;
import org.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        Order order = orderService.findById( id );
        System.out.println(order );
    }

    @PostMapping("/update")
    public void updateOrder(@PathParam( "id" ) Integer id
            , @PathParam( "userid" ) Integer userid
            , @PathParam( "hotelid" ) String hotelid
            , @PathParam( "totalprice" ) String totalprice
            , @PathParam( "days" ) String days){

        orderService.updateOrder( id,userid, hotelid, totalprice, days );

    }

    @DeleteMapping
    public void deleteOrder(@PathParam( "id" ) Integer id){

        orderService.deleteOrder( id );

    }

    @PutMapping
    public void addOrder(@PathParam( "userid" ) Integer userid
            , @PathParam( "hotelid" ) String hotelid
            , @PathParam( "totalprice" ) String totalprice
            , @PathParam( "days" ) String days){

        orderService.addOrder( userid,  hotelid, totalprice, days);

    }
}
