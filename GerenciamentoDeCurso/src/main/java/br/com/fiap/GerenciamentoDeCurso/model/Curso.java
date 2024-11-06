package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CP06_CURSO")
public class Curso {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nm_curso")
    private String nomeCurso;

    @Column(name = "desc_descricao")
    private String descricao;
    @Column(name = "cargaHoraria")
    private Float cargaHoraria;

}
