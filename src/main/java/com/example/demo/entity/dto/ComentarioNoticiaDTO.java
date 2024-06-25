package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComentarioNoticiaDTO {
    @JsonProperty("idNoticia")
    private Long idNoticia;

    @JsonProperty("conteudo")
    private String conteudo;

    @JsonProperty("idUsuario")
    private Long idUsuario;
}
