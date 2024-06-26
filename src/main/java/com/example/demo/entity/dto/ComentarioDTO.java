package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComentarioDTO {
    private Long idcomentario;
    private String conteudo;
    private String nomeUsuario;
}
