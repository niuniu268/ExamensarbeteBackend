package org.example.elasticsearchservice.service;

import org.example.elasticsearchservice.pojo.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    public Optional <Hotel> findHotelById(String id);

    public List <Hotel> findHotelsByCity(String city);
}
