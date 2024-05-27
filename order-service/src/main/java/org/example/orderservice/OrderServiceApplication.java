package org.example.orderservice;

import org.example.feignservice.config.FeignConfig;
import org.example.feignservice.controller.UserController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("org.example.orderservice.mapper")
@EnableFeignClients(clients = UserController.class, defaultConfiguration = FeignConfig.class)
public class OrderServiceApplication {

    public static void main (String[] args) {
        SpringApplication.run( OrderServiceApplication.class, args );
    }

}
