package com.zerp.taskmanagementproject.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zerp.taskmanagementproject.entity.ApplicationUser;
import com.zerp.taskmanagementproject.entity.Role;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user detail service");
        if(!username.equals("magesh"))
            throw new UsernameNotFoundException("Username not found");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));
        return new ApplicationUser(1, "magesh", passwordEncoder.encode("password"), roles);
    }
    
}
