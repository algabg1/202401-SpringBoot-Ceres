package com.example.demo.controller;

import com.example.demo.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> Generic que deve ser substituido pelo tipo da entidade
 * @param <R> define o tipo de retorno para update, create e delete
 */
public interface GenericController<T,R>{


   ResponseEntity<List<T>> listAll();

    public abstract ResponseEntity<R> update(@PathVariable Long id, @RequestBody T updatedEntity);

    public abstract ResponseEntity<R> create(@RequestBody T entity);

    public abstract ResponseEntity<R> delete(@PathVariable Long id);

    public abstract ResponseEntity<T> getById(@PathVariable Long id);

}
