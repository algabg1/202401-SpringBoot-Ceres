package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.ComentarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioJpaRepository extends JpaRepository<ComentarioEntity, Long> {
    @Query("SELECT c FROM comentario c")
    List<ComentarioEntity> findComentariosWithUser();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO comentario (idusuario, idnoticia, conteudo) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void adicionarComentario(Long idUsuario, Long idNoticia, String conteudo);
}
