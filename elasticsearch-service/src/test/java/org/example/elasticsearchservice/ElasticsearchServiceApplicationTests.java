package org.example.elasticsearchservice;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.example.elasticsearchservice.pojo.Hotel;

import org.example.elasticsearchservice.repository.HotelRepository;
import org.example.elasticsearchservice.service.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.meta.When;
import java.io.IOException;
import java.util.Optional;

@SpringBootTest
class ElasticsearchServiceApplicationTests {

    @Test
    void contextLoads () {
    }
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelService hotelService;


    @Test
    void test_elasticsearchrepository () throws IOException {

        RestClient restClient = RestClient.builder(
                new HttpHost( "192.168.1.72", 9200, "http" ) ).build( );

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        ElasticsearchClient client = new ElasticsearchClient(transport);

        GetResponse <Hotel> getResponse = client.get( s -> s
                .index("hotel-index")
                .id("36934"), Hotel.class);
        Hotel source = getResponse.source();

        System.out.println(source.getAddress() );

    }

    @Test
    void test_HotelRepository_servicebyId(){
        Optional <Hotel> hotel = hotelRepository.findHotelById( "36934" );

        System.out.println(hotel );
    }


    @Test
    void test_HotelService_servicebyId(){

        Optional <Hotel> hotel = hotelService.findHotelById( "36934" );

        System.out.println(hotel );
    }


}