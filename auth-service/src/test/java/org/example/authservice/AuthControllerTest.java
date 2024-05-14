package org.example.authservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.log.Log;
import org.example.authservice.config.JWTprovider;
import org.example.authservice.config.SecurityConfig;
import org.example.authservice.controller.AuthController;
import org.example.userservice.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    private static final Logger log = LoggerFactory.getLogger( AuthControllerTest.class );
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JWTprovider tokenProvider;


    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private SecurityConfig securityConfig;



    @Test
    @WithMockUser(roles = {"USER"})
    public void testAuthenticateUser_Success() throws Exception {
        // Setup
        String username = "abc";
        String password = "abc";
        String jwt = "dummy.jwt.token";

        UserDetails mockUserDetails = new User(username, password, AuthorityUtils.createAuthorityList("USER"));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = new UsernamePasswordAuthenticationToken(mockUserDetails, null, mockUserDetails.getAuthorities());

        when(userDetailsService.loadUserByUsername(username)).thenReturn(mockUserDetails);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(auth);
        when(tokenProvider.generateToken(auth)).thenReturn(jwt);

        // Execute & Assert
        mockMvc.perform(post("/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string(jwt));

//        verify(userDetailsService).loadUserByUsername(username);
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(tokenProvider).generateToken(any(Authentication.class));
    }


    @Test
    @WithMockUser(roles = {"USER"})
    public void shouldAuthenticateUserAndReturnJWT2() throws Exception {

        String username = "user";
        String jwtToken = "mock.jwt.token.here";
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, "password", AuthorityUtils.createAuthorityList("USER"));

        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities()));
        when(tokenProvider.generateToken(any(Authentication.class))).thenReturn(jwtToken);

        mockMvc.perform(post("/auth/signin")
                        .with(csrf())
                        .param("username", username))
                .andExpect(status().isOk())
                .andExpect(content().string(jwtToken));
    }

}
