package com.example.demo.entity;


import com.example.demo.Enum.CategoriaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

/**
 * @Author: Breno Ricardo. Teste.
 */
@Entity(name = "planta")
@Table(name = "planta")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlantaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplanta")
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(name = "nomecientifico")
    private String nome_cientifico;

    @Column(name = "descricao")
    private String descricao;

    private String origem;

    private String cuidados;

    /*@Lob
    @Column(name = "imagem")
    private byte[] imagem;*/

    private Date dataregistro;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

}
