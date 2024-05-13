package org.example.userservice.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.example.userservice.config.PatternProperties;
import org.example.userservice.pojo.UserInfo;
import org.example.userservice.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserinfoController {
    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private PatternProperties properties;

    @GetMapping("prop")
    public PatternProperties properties(){
        return properties;
    }

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format( DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @PostMapping
    public void findByUserName(@PathParam( "username" ) String username, @PathParam( "password" ) String password){
        System.out.println(username );

        UserInfo byUsername = userinfoService.findByUsername( username );

        System.out.println( byUsername );
    }
}