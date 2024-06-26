package com.example.demo.controller;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.ProjetoDTO;
import com.example.demo.repository.ProjetoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController implements GenericController<ProjetoEntity, String>{

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @GetMapping("/projetos")
    public ResponseEntity<List<ProjetoEntity>> listAll() {
        List<ProjetoEntity>projetoEntities = projetoRepository.findAll();
        return ResponseEntity.ok(projetoEntities);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> update(Long id, ProjetoEntity updatedEntity) {
        Optional<ProjetoEntity> projetoEntityOptional = projetoRepository.findById(id);

        if (projetoEntityOptional.isPresent()) {
            ProjetoEntity projetoEntity = projetoEntityOptional.get();
            projetoEntity.setNome(updatedEntity.getNome());
            projetoEntity.setDescricao(updatedEntity.getDescricao());
            //Preciso dar um findById agora na pessoa
            this.projetoRepository.save(projetoEntity);
            return ResponseEntity.ok("usuario atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @deprecated  nao sera mais utilizado e nao pode ser removido. Está aqui para depurar
     * @param entity
     * @return
     */
    @Deprecated
    @Override
    public ResponseEntity<String> create(@RequestBody ProjetoEntity entity) {
        //this.projetoRepository.save(entity);
        return ResponseEntity.ok("criado");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody @Valid ProjetoDTO entity) {
        boolean status =  this.projetoService.criarProjeto(entity);
        if(status){
            return ResponseEntity.status(HttpStatus.CREATED).body("Projeto criado com sucesso!");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Nao criado!");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<ProjetoEntity> projetoEntityOptional = projetoRepository.findById(id);

        if (projetoEntityOptional.isPresent()) {
            this.projetoRepository.deleteById(id);
            return ResponseEntity.ok("Projeto excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoEntity> getById(@PathVariable Long id) {
        Optional<ProjetoEntity> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getProjetosByUserId(@PathVariable Long id){
        List<ProjetoEntity>projetoEntities = projetoService.getProjetosByUserId(id);
        return ResponseEntity.ok(projetoEntities);
    }
}
