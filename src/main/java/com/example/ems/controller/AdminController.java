package com.example.ems.controller;

import com.example.ems.entity.Admins;
import com.example.ems.service.impl.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class AdminController {
    private AdminService service;

    @PostMapping("/register")
    public Admins register(@RequestBody Admins admin){
        return service.register(admin);
    }
}
