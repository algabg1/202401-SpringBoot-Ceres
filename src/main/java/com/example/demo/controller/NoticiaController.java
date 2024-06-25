package com.example.demo.controller;

import com.example.demo.entity.NoticiaEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.NoticiaDTO;
import com.example.demo.repository.NoticiaRepository;
import com.example.demo.service.NoticiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noticia")
public class NoticiaController implements GenericController<NoticiaEntity, String> {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/noticias")
    @Override
    public ResponseEntity<List<NoticiaEntity>> listAll() {
        List<NoticiaEntity>noticiaEntitiesList = noticiaRepository.findAll();
        return ResponseEntity.ok(noticiaEntitiesList);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> update(Long id, NoticiaEntity updatedEntity) {
        return null;
    }

    @Deprecated
    @Override
    public ResponseEntity<String> create(NoticiaEntity entity) {
        this.noticiaRepository.save(entity);
        return ResponseEntity.ok("Noticia criado com sucesso");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody @Valid NoticiaDTO entity) {
        this.noticiaService.create(entity);
        return ResponseEntity.ok("Noticia criado com sucesso");
    }

    @Override
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> delete(Long id) {

        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<NoticiaEntity> getById(Long id) {
        Optional<NoticiaEntity> noticia = noticiaRepository.findById(id);
        if (noticia.isPresent()) {
            return ResponseEntity.ok(noticia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
