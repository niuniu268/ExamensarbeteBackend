package org.example.orderservice.service;

import org.example.feignservice.controller.UserController;
import org.example.feignservice.pojo.UserInfo;
import org.example.orderservice.mapper.OrderMapper;
import org.example.orderservice.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserController userController;

    @Override
    public Order findById (Integer id) {

        Order orderMapperById = orderMapper.findById( id );

        System.out.println(orderMapperById );
        UserInfo userInfo = userController.findById( orderMapperById.getUserid( ) );

        System.out.println(userInfo );
        orderMapperById.setUserInfo( userInfo );

        return orderMapperById;
    }
}
