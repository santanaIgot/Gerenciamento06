package br.com.fiap.GerenciamentoDeCurso.repository;

import br.com.fiap.GerenciamentoDeCurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
