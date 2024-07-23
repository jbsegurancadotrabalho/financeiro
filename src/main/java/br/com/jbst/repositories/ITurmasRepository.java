package br.com.jbst.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbst.entities.Turmas;

public interface ITurmasRepository extends JpaRepository<Turmas, UUID> {

}
