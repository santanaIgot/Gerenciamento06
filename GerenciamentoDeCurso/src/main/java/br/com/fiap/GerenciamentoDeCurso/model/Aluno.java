package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CP06_ALUNO")
@Getter@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "id_aluno")
    private Long id ;
    @Column(name = "nm_aluno")
    private String nome ;
    @Column(name = "email")
    private String email;

    @ManyToMany
    @Column(name = "curso")
    @JoinColumn(name = "cd_curso")
    private Curso curso;


}
