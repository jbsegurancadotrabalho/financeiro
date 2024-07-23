package br.com.jbst.repositories;

import java.util.List;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jbst.entities.PessoaFisica;

public interface IPessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {
    
	
    List<PessoaFisica> findByUsuario_Id(UUID idUsuario);

	}