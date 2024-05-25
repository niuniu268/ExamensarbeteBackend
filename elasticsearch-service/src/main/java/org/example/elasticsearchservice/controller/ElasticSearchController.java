package org.example.elasticsearchservice.controller;

import jakarta.websocket.server.PathParam;
import org.example.elasticsearchservice.pojo.Hotel;
import org.example.elasticsearchservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/search")
public class ElasticSearchController {

    @Autowired
    private HotelService hotelServiceImpl;

    @PostMapping
    public void searchById(@PathParam( "id" )String id){

        Optional <Hotel> hotelById = hotelServiceImpl.findHotelById( id );

        System.out.println( hotelById );
    }

}
