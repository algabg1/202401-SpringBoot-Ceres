package com.example.demo.repository.jpaRepository;

import com.example.demo.entity.ProjetoEntity;
import com.example.demo.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetoJpaRepository extends JpaRepository<ProjetoEntity, Long>, JpaSpecificationExecutor<ProjetoEntity> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO projeto (nome, descricao, idusuario, tipo_projeto) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void adicionarProjeto(String nome, String descricao, Long idusuario, String tipo_projeto);

    @Query("SELECT p FROM projeto p WHERE p.idusuario = :idusuario")
    List<ProjetoEntity> findByIdUsuario(@Param("idusuario") Long idusuario);

}
