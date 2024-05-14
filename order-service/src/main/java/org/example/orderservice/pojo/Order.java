package org.example.orderservice.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private Integer id;
    private Integer userid;
    private String hotelid;
    private String totalprice;
    private String days;

}
