package br.com.fiap.GerenciamentoDeCurso.repository;

import br.com.fiap.GerenciamentoDeCurso.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
