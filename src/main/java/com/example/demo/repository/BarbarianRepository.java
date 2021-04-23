package com.example.demo.repository;

import com.example.demo.model.Barbarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbarianRepository extends JpaRepository<Barbarian,Long> {
}
