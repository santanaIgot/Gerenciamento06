package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "TB_CP06_CURSO")
@Getter@Setter
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_curso")
    private String nomeCurso;

    @Column(name = "desc_descricao")
    private String descricao;

    @Column(name = "cargaHoraria")
    @Min(1)
    private int cargaHoraria;



    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> aluno;


}
