package com.agritech.agritechgrow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agritech.agritechgrow.dao.UserRepository;
import com.agritech.agritechgrow.entities.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean adduser(User user){
        try{
            String password = passwordEncoder.encode(user.getPassword());
            System.out.println(password);
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getByUsername(String username){
        try {
            return userRepository.findById(username).get();
        }catch(Exception e){
            return null;
        }
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }


}
