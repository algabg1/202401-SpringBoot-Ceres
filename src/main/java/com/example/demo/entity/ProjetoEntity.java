package com.example.demo.entity;
import com.example.demo.Enum.CategoriaEnum;
import com.example.demo.Enum.TipoProjetoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "projeto")
@Table(name = "projeto")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idProjeto")
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojeto")
    private Long idProjeto;

    @Column(name = "idusuario")
    private Long idusuario;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", nullable = false)
    @JsonBackReference
    private UsuarioEntity usuario;*/

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_projeto")
    private TipoProjetoEnum tipoProjeto;


}
