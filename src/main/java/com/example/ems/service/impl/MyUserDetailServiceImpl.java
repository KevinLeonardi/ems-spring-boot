package com.example.ems.service.impl;

import com.example.ems.dto.UserPrincipalDTO;
import com.example.ems.entity.Admins;
import com.example.ems.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AdminRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins admin = repo.findByUsername(username);
        if (admin ==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipalDTO(admin);
    }
}
