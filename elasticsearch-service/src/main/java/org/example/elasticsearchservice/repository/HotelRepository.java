package org.example.elasticsearchservice.repository;

import org.example.elasticsearchservice.pojo.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends ElasticsearchRepository<Hotel, String> {

    Optional<Hotel> findHotelById (String id);

    List <Hotel> findHotelsByCity(String city);
}
