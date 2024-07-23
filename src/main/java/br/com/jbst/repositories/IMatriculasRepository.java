package br.com.jbst.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbst.entities.Matriculas;

public interface IMatriculasRepository extends JpaRepository<Matriculas, UUID> {

}
