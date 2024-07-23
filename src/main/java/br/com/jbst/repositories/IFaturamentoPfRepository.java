package br.com.jbst.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jbst.DTO.GetFaturamentopfDto;
import br.com.jbst.entities.Faturamento;
import br.com.jbst.entities.FaturamentoPf;
import br.com.jbst.entities.Usuario;

public interface IFaturamentoPfRepository extends JpaRepository<FaturamentoPf, UUID> {

   
    List<FaturamentoPf> findByFaturaFechada(boolean faturaFechada);
    
    @Query("SELECT f FROM FaturamentoPf f " +
    	       "WHERE MONTH(f.dataInicio) = :mes " +
    	       "AND YEAR(f.dataInicio) = :ano")
    	List<FaturamentoPf> findFaturamentoByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);

    
    @Query("SELECT f FROM Faturamento f WHERE f.faturaFechada = :faturaFechada")
    List<Faturamento> findFaturamentoByFaturaFechada(@Param("faturaFechada") boolean faturaFechada);


    @Query("SELECT f FROM FaturamentoPf f " +
    	       "INNER JOIN FETCH f.pessoaFisica pf " +
    	       "INNER JOIN pf.usuario u " +
    	       "WHERE u.id = :idUsuario " +
    	       "AND MONTH(f.dataInicio) = :mes " +
    	       "AND YEAR(f.dataInicio) = :ano")
    	List<FaturamentoPf> findByUsuarioIdAndMesAndAno(
    	        @Param("idUsuario") UUID idUsuario,
    	        @Param("mes") int mes,
    	        @Param("ano") int ano);

    
    @Query("SELECT f FROM FaturamentoPf f " +
 	       "INNER JOIN FETCH f.pessoaFisica pf " +
    	       "WHERE pf.usuario.id = :idUsuario " +
    	       "AND f.faturaFechada = false")
    	List<FaturamentoPf> findFaturasAbertasByUsuarioId(@Param("idUsuario") UUID idUsuario);

    
    
 }

    

