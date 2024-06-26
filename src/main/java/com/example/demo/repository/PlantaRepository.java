package com.example.demo.repository;

import com.example.demo.entity.PlantaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantaRepository extends JpaRepository<PlantaEntity, Long> {
}
