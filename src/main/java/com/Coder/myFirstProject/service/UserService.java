package com.Coder.myFirstProject.service;

import com.Coder.myFirstProject.entity.JournalEntry;
import com.Coder.myFirstProject.entity.User;
import com.Coder.myFirstProject.repository.JournalEntryRepository;
import com.Coder.myFirstProject.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public  void saveEntry(User user){
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
