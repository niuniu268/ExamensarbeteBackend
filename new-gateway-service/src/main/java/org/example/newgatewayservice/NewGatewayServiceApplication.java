package org.example.newgatewayservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.newgatewayservice.mapper")
public class NewGatewayServiceApplication {

    public static void main (String[] args) {
        SpringApplication.run( NewGatewayServiceApplication.class, args );
    }

}
