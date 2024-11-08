package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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
    @JoinTable(
            name = "TB_CP06_ALUNO_CURSO",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "cd_curso")
    )
    private Set<Curso> cursos;


}
