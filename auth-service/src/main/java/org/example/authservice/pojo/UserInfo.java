package org.example.authservice.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Boolean enable;
}
