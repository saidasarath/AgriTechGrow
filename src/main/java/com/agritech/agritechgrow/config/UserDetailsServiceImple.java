package com.agritech.agritechgrow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.agritech.agritechgrow.dao.UserRepository;
import com.agritech.agritechgrow.entities.User;

public class UserDetailsServiceImple implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if(user == null)
            throw new UsernameNotFoundException("Could not found user");
        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }
    
}
