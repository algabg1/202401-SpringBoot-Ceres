package com.example.demo.controller;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.jpaRepository.UsuarioJpaRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements GenericController<UsuarioEntity, String>{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Apenas para teste
     * @return retorna uma lista contendo todos os usuarios cadastrados e sua composição
     */
    @GetMapping("/usuarios-all")
    @Override
    public ResponseEntity<List<UsuarioEntity>> listAll() {
        List<UsuarioEntity> pessoa = usuarioService.listAll();
        return ResponseEntity.ok(pessoa);
    }


    /**
     * @return retorna uma lista contendo todos os usuários cadastrados como DTOs
     */
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDTO>> listAllDtos() {
        List<UsuarioDTO> pessoas = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(pessoas);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        UsuarioEntity user = usuarioService.update(id, usuario);
        if (user != null) {
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com o ID " + id);
        }
    }

    @PostMapping("/criar")
    @Override
    public ResponseEntity<String> create(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);

        if (usuarioEntityOptional.isPresent()) {
            this.usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuário excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UsuarioEntity> getById(Long id) {
        UsuarioEntity usuario = usuarioService.getById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
