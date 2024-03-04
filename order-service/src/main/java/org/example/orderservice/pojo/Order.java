package org.example.orderservice.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private int price;
    private int score;
    private String brand;
    private String city;
    private String starName;
    private String business;
    private String latitude;
    private String longitude;
    private String pic;


}
