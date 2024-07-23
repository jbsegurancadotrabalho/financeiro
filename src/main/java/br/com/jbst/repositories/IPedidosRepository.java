package br.com.jbst.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jbst.entities.Faturamento;
import br.com.jbst.entities.Pedidos;

public interface IPedidosRepository extends JpaRepository<Pedidos, UUID> {

	  @Query("SELECT p FROM Pedidos p WHERE EXTRACT(MONTH FROM p.dataHoraCriacao) = :mes AND EXTRACT(YEAR FROM p.dataHoraCriacao) = :ano")
	  List<Pedidos> findPedidosByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);
	 
	  @Query("SELECT p FROM Pedidos p WHERE p.pedidoFechado = :pedidoFechado")
	    List<Pedidos> findPedidoByPedidoFechado(@Param("pedidoFechado") boolean pedidoFechado);
	}