package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.PlantaProjetoEntity;
import com.example.demo.entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantaProjetoJpaRepository
        extends JpaRepository<PlantaProjetoEntity, Long>, JpaSpecificationExecutor<PlantaProjetoEntity> {
}
