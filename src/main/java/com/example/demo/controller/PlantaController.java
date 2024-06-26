package com.example.demo.controller;

import com.example.demo.entity.PlantaEntity;
import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.PlantaDTO;
import com.example.demo.repository.PlantaRepository;
import com.example.demo.service.PlantaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planta")
public class PlantaController implements GenericController<PlantaEntity, String>{

    @Autowired
    private PlantaRepository plantaRepository;

    @Autowired
    private PlantaService plantaService;

    @GetMapping("/plantas")
    @Override
    public ResponseEntity<List<PlantaEntity>> listAll() {
        List<PlantaEntity>plantaEntities = plantaRepository.findAll();
        return ResponseEntity.ok(plantaEntities);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> update(Long id, PlantaEntity updatedEntity) {
        Optional<PlantaEntity> plantaOptional = plantaRepository.findById(id);

        if (plantaOptional.isPresent()) {
            PlantaEntity plantaEntity = plantaOptional.get();
            plantaEntity.setNome_cientifico(updatedEntity.getNome_cientifico());
            plantaEntity.setDescricao(updatedEntity.getDescricao());
            plantaEntity.setOrigem(updatedEntity.getOrigem());
            plantaEntity.setCuidados(updatedEntity.getCuidados());
            //plantaEntity.setImagem(updatedEntity.getImagem());
            plantaEntity.setDataregistro(updatedEntity.getDataregistro());
            plantaEntity.setCategoria(updatedEntity.getCategoria());

            plantaRepository.save(plantaEntity);
            return ResponseEntity.ok("Planta atualizada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@PostMapping("/criar")
    @Deprecated
    @Override
    public ResponseEntity<String> create(@RequestBody @Valid PlantaEntity entity) {
        this.plantaRepository.save(entity);
        return ResponseEntity.ok("Planta criado com sucesso");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody @Valid PlantaDTO entity) {
        plantaService.criar(entity);
        return ResponseEntity.ok("Planta criado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<PlantaEntity> plantaEntityOptional = plantaRepository.findById(id);

        if (plantaEntityOptional.isPresent()) {
            this.plantaRepository.deleteById(id);
            return ResponseEntity.ok("planta excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PlantaEntity> getById(Long id) {
        Optional<PlantaEntity> planta = plantaRepository.findById(id);
        if (planta.isPresent()) {
            return ResponseEntity.ok(planta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
