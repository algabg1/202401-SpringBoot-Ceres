package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "plantaprojeto")
@Table(name = "plantaprojeto")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlantaProjetoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplantaprojeto")
    private Long id;

    @OneToOne
    @JoinColumn(name = "idplanta") // Nome da coluna na tabela plantaprojeto que referencia a tabela planta
    @JsonManagedReference
    private PlantaEntity planta;

    @OneToOne
    @JoinColumn(name = "idprojeto")
    @JsonManagedReference// Nome da coluna na tabela plantaprojeto que referencia a tabela projeto
    private ProjetoEntity projeto;



}
