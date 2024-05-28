package org.example.userservice.service;

import org.example.userservice.maper.UserinfoMapper;
import org.example.userservice.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public UserInfo findByUsername (String username) {
        return userinfoMapper.findByUsername( username );
    }

    @Override
    public UserInfo findById (Integer id) {
        return userinfoMapper.findById( id );
    }

    @Override
    public void updateUser (String username, String password) {

        userinfoMapper.update( username,  password );
    }

    @Override
    public void addUser (UserInfo userInfo) {

        userinfoMapper.insert( userInfo );
    }

    @Override
    public void deleteUser (String username) {

        userinfoMapper.delete( username );
    }
}
