package org.example.userservice.service;

import org.example.userservice.pojo.UserInfo;

public interface UserinfoService {
    UserInfo findByUsername(String username);
}
