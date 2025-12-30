package com.example.ems.service.impl;

import com.example.ems.entity.Admins;
import com.example.ems.repository.AdminRepo;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdminService {
    private AdminRepo repo;
    private JWTService jwtService;
    private BCryptPasswordEncoder encoder;
    AuthenticationManager authManager;


    public Admins register(Admins admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));
        return repo.save(admin);
    }

    public String verify(Admins admin) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(admin.getUsername());
        return  "Failed";
    }
}
