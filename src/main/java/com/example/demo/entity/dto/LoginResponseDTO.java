package com.example.demo.entity.dto;

import com.example.demo.entity.UsuarioEntity;

public record LoginResponseDTO (String token, UsuarioEntity usuario){
}
