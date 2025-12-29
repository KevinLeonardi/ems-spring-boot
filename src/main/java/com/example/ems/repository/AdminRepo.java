package com.example.ems.repository;

import com.example.ems.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admins,Integer> {
    Admins findByUsername(String username);
}
