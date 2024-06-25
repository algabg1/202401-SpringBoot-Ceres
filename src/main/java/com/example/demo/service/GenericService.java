package com.example.demo.service;

import com.example.demo.controller.GenericController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 *
 * @param <T> Tipo da Entidade
 * @param <L> Representa o tipo do service
 */
@Setter
@Getter
public abstract class GenericService <T,L extends JpaRepository<?,?>>{

    @Autowired
    private L service;

    public abstract List<T> listAll();

    public abstract T update(Long id, T updatedEntity);

    public abstract T create(T entity);

    public abstract T delete(Long id);

    public abstract T getById(Long id);



}
