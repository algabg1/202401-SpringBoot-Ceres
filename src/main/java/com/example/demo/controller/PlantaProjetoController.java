package com.example.demo.controller;

import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.PlantaProjetoEntity;
import com.example.demo.repository.PlantaProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projeto-planta")
public class PlantaProjetoController implements GenericController<PlantaProjetoEntity, Long> {

    @Autowired
    private PlantaProjetoRepository plantaProjetoRepository;

    @GetMapping("/projetos-planta")
    @Override
    public ResponseEntity<List<PlantaProjetoEntity>> listAll() {
        List<PlantaProjetoEntity>plantaProjetoEntities = this.plantaProjetoRepository.findAll();
        return ResponseEntity.ok(plantaProjetoEntities);
    }

    @Override
    public ResponseEntity<Long> update(Long id, PlantaProjetoEntity updatedEntity) {
        return null;
    }

    @Override
    public ResponseEntity<Long> create(PlantaProjetoEntity entity) {
        return null;
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PlantaProjetoEntity> getById(Long id) {
        return null;
    }
}
