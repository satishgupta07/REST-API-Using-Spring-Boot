package com.jwt.services;

import com.jwt.dao.UserRepository;
import com.jwt.model.CustomUserDetails;
import com.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(userName);

        if(user==null) {
            throw new UsernameNotFoundException("User not found !!");
        }
        else {
            return new CustomUserDetails(user);
        }

//        if(userName.equals("Satish")) {
//            return new User("Satish","satish123", new ArrayList<>());
//        }
//        else {
//            throw new UsernameNotFoundException("User not found !!");
//        }

    }
}
