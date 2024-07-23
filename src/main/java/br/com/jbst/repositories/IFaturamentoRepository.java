package br.com.jbst.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jbst.DTO.GetFaturamentopfDto;
import br.com.jbst.entities.Faturamento;
import br.com.jbst.entities.FaturamentoPf;
import br.com.jbst.entities.PessoaFisica;

public interface IFaturamentoRepository extends JpaRepository<Faturamento, UUID> {

    @Query("SELECT f FROM Faturamento f WHERE EXTRACT(MONTH FROM f.data_inicio) = :mes AND EXTRACT(YEAR FROM f.data_inicio) = :ano")
    List<Faturamento> findFaturamentoByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);

    @Query("SELECT f FROM Faturamento f WHERE f.faturaFechada = :faturaFechada")
    List<Faturamento> findFaturamentoByFaturaFechada(@Param("faturaFechada") boolean faturaFechada);




}
