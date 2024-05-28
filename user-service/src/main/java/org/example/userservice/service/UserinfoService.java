package org.example.userservice.service;

import org.example.userservice.pojo.UserInfo;

public interface UserinfoService {
    UserInfo findByUsername(String username);

    UserInfo findById(Integer id);

    void updateUser(String username, String password);

    void addUser(UserInfo userInfo);

    void deleteUser(String username);
}
