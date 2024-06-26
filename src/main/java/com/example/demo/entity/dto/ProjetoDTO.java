package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.Setter;


public record ProjetoDTO(String nome, String descricao, Long idUsuario, String tipoProjeto) {
}
