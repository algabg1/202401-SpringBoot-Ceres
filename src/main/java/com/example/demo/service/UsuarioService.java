package com.example.demo.service;

import com.example.demo.entity.ComentarioEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.entity.dto.ComentarioDTO;
import com.example.demo.entity.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import io.micrometer.common.util.internal.logging.InternalLogLevel;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService extends GenericService<UsuarioEntity, UsuarioRepository>{


    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioEntity> usuarios = getService().findAll();
        return usuarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }



    private UsuarioDTO convertToDTO(UsuarioEntity usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    /**
     * Implementar regra de negocio aqui se houver
     * @return
     */
    @Override
    public List<UsuarioEntity> listAll() {
        return getService().findAll();
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity updatedEntity) {
        Optional<UsuarioEntity> user = getService().findById(id);
        if (user.isPresent()) {
            UsuarioEntity existingUser = user.get();
            existingUser.setNome(updatedEntity.getNome());
            existingUser.setEmail(updatedEntity.getEmail());
            existingUser.setSenha(updatedEntity.getSenha());

            getService().save(existingUser);
            return updatedEntity;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioEntity create(UsuarioEntity entity) {
        try {
            if(getService().findByEmail(entity.getEmail()) != null){
                throw new IllegalArgumentException("Email já registrado");
            }
            return this.getService().save(entity);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro.");
        }
    }

    @Override
    public UsuarioEntity delete(Long id) {
        return null;
    }

    @Override
    public UsuarioEntity getById(Long id) {
        Optional<UsuarioEntity>usuario = getService().findById(id);
        if(usuario.isPresent()){
            return usuario.get();
        }
        else {
            return null;
        }
    }
}
