package br.com.jbst.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbst.entities.Funcao;

public interface IFuncaoRepository extends JpaRepository<Funcao, UUID>{

}
