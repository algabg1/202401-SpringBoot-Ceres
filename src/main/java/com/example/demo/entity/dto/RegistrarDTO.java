package com.example.demo.entity.dto;

import com.example.demo.Enum.RoleUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RegistrarDTO {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String login;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("user_role")
    private RoleUser role;
}
