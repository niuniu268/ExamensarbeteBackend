package org.example.userservice.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserInfo implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String role;
}
