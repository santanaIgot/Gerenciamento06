package br.com.fiap.GerenciamentoDeCurso.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "TB_CP06_MATRICULO")
public class Matricula {
    @Id
    @GeneratedValue
    @Column(name = "cd_matricula")
    private Long id ;
    @Column(name = "st_status")
    private Boolean status;
    @Column(name = "dt_dataMatricula")
    private LocalDate dataMatricula;
}
