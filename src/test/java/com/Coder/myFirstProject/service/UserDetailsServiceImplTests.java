package com.Coder.myFirstProject.service;

import com.Coder.myFirstProject.entity.User;
import com.Coder.myFirstProject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)         // Automatically instantiate the mock object
public class UserDetailsServiceImplTests {

    @InjectMocks   // It inject the mock in this class and also instantiate this class object
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this); // manual way to initialize mock (Bad practice)
//    }

    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("faisal").password("123").roles(new ArrayList<>()).build());
        UserDetails user=userDetailsService.loadUserByUsername("faisal");
        Assertions.assertNotNull(user);
    }
}
