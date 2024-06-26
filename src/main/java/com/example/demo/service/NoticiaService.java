package com.example.demo.service;

import com.example.demo.entity.NoticiaEntity;
import com.example.demo.entity.dto.NoticiaDTO;
import com.example.demo.repository.jpaRepository.NoticiaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaJpaRepository noticiaJpaRepository;

    public boolean create(NoticiaDTO entity){
        java.sql.Date date = Date.valueOf(entity.dataPublicacao());
        noticiaJpaRepository.create(entity.titulo(), entity.conteudo(), date, entity.idusuario());
        return true;
    }

}
