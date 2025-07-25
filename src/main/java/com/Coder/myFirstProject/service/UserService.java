package com.Coder.myFirstProject.service;

import com.Coder.myFirstProject.entity.User;
import com.Coder.myFirstProject.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        System.out.println(">>> PublicController initialized");
    }


    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public  boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }catch (Exception e){
            log.trace("Exception in creating trace {}", user.getUserName());
            log.debug("Exception in creating debug {}", user.getUserName());
            log.info("Exception in creating info {}", user.getUserName());
            log.warn("Exception in creating warn {}", user.getUserName());
            log.error("Exception in creating error {}", user.getUserName());   // {}->user.getUserName()
            return false;
        }
    }

    public  void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }
}



