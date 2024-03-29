package org.example.authservice.service;

import org.example.authservice.mapper.UserPrincipalMapper;
import org.example.authservice.mapper.UserinfoMapper;
import org.example.authservice.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        UserInfo userInfo = userinfoMapper.findByUsername( username );
        return UserPrincipalMapper.userToPrincipal( userInfo );
    }
}
