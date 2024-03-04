package org.example.orderservice;

import org.example.orderservice.controller.OrderController;
import org.example.orderservice.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderController orderController;

    @Test
    void testFindById () {

        orderMapper.findById( 36934 );
    }

    @Test
    void testControllerFindById () {

        orderController.findById( 36934 );
    }


}
