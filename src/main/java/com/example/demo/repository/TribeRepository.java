package com.example.demo.repository;

import com.example.demo.model.Tribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribeRepository extends JpaRepository<Tribe,Long> {
}
