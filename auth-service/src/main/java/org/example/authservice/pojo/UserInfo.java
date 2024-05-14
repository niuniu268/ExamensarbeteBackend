package org.example.authservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
