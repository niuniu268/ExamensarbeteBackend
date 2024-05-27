package org.example.feignservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Boolean enable;


}
