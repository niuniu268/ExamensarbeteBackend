package org.example.elasticsearchservice.service;

import org.example.elasticsearchservice.pojo.Hotel;
import org.example.elasticsearchservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImp implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Optional <Hotel> findHotelById (String id) {
        return hotelRepository.findHotelById( id );
    }

    @Override
    public List <Hotel> findHotelsByCity (String city) {

        return hotelRepository.findHotelsByCity( city );
    }


}
