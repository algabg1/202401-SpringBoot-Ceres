package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.NoticiaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface NoticiaJpaRepository extends JpaRepository<NoticiaEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO noticia (titulo, conteudo, data, idusuario) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void create(String titulo, String conteudo, Date data, Long idusuario);

}
