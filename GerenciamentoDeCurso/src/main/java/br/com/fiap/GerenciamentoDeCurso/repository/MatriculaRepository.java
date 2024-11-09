package br.com.fiap.GerenciamentoDeCurso.repository;

import br.com.fiap.GerenciamentoDeCurso.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
