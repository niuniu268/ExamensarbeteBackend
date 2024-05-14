package org.example.authservice;

import org.example.authservice.mapper.UserinfoMapper;
import org.example.authservice.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

@SpringBootTest
class AuthServiceApplicationTests {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    void contextLoads () {
    }

    @Test
    void test_UserInfoRepository_servicebyId(){
        UserInfo username = userinfoMapper.findByUsername( "abc" );

        System.out.println(username );
    }

    @Test
    void test_userinfo_service_servicebyId(){
        UserDetails userDetails = userDetailsService.loadUserByUsername( "abc" );
        System.out.println(userDetails.getAuthorities() );
        System.out.println(userDetails.getPassword() );
        System.out.println(userDetails.getUsername() );

    }
}
