package org.example.feignservice.controller;

import org.example.feignservice.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", url = "http://localhost:8082")
public interface UserController {

    @GetMapping("/user/{id}")
    UserInfo findById(@PathVariable("id") Integer id);
}
