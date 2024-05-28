package org.example.orderservice.service;

import org.example.orderservice.pojo.Order;
import org.springframework.stereotype.Service;


public interface OrderService {

    Order findById(Integer id);

    void addOrder(Integer userid, String hotelid, String totalprice, String days);

    void updateOrder(Integer id, Integer userid, String hotelid, String totalprice, String days);

    void deleteOrder(Integer id);

}
