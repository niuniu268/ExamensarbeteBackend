package org.example.newgatewayservice.mapper;

import org.example.newgatewayservice.pojo.UserInfo;
import org.example.newgatewayservice.pojo.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public class UserPrincipalMapper {
    public static UserPrincipal userToPrincipal(UserInfo userInfo){
        UserPrincipal userPrincipal = new UserPrincipal( );

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (userInfo.getEnable()) {
            authorities.add(new SimpleGrantedAuthority("USER"));
        }

        userPrincipal.setAuthorities( authorities );
        userPrincipal.setEnabled( userInfo.getEnable() );
        userPrincipal.setUsername( userInfo.getUsername() );
        userPrincipal.setPassword( userInfo.getPassword() );

        return userPrincipal;
    }
}
