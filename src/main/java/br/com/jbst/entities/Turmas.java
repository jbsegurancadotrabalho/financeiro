package br.com.jbst.entities;

import java.time.Instant;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "turmas")
public class Turmas {
	
	
	@Id 	// Campo 1
	@Column(name = "idturmas")
	private UUID idTurmas;
	
	// Campo 2
	@Column(name = "numeroturma", nullable = false)
	private Integer numeroTurma;
	
	// Campo 3
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datainicio", nullable = false)
	private Instant datainicio;
	
	// Campo 4
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datafim", nullable = false)
	private Instant datafim;
	
	// Campo 5
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validadedocurso", nullable = true)
	private Instant validadedocurso;
	
	// Campo 6
	@Column(name = "cargahoraria", length = 255, nullable = false)
	private String  cargahoraria;
	
	// Campo 7
	@Column(name = "modalidade", length = 255, nullable = false)
	private String modalidade;
	
	// Campo 8
	@Column(name = "status", length = 255, nullable = false)
	private String status;
	
	// Campo 9
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	// Campo 10
	@Column(name = "diasespecificos", length = 255, nullable = false)
	private String diasespecificos;
	
	// Campo 11
	@Column(name = "tipo", length = 255, nullable = false)
	private String tipo;
	
	// Campo 12
	@Column(name = "nivel", nullable = false)
	private String nivel;
	
	// Campo 13
	@Column(name = "validade", length = 255, nullable = false)
	private String validade;
	
	// Campo 14
	@Column(name = "dia", length = 255, nullable = false)
	private String dia;
	
	// Campo 15
	@Column(name = "mes", length = 255, nullable = false)
	private String mes;
	
	// Campo 16
	@Column(name = "ano", length = 255, nullable = false)
	private String ano;
	
	// Campo 17
	@Column(name = "primeirodia", length = 255, nullable = false)
	private String primeirodia;

	// Campo 18
	@Column(name = "segundodia", length = 255, nullable = true)
	private String segundodia;

	// Campo 19
	@Column(name = "terceirodia", length = 255, nullable = true)
	private String terceirodia;

	
	// Campo 20
	@Column(name = "quartodia", length = 255,  nullable = true)
	private String quartodia;

	// Campo 21
	@Column(name = "quintodia", length = 255, nullable = true)
	private String quintodia;
    
	// Campo 22
	@Column(name = "observacoes_gerais ", length = 1000, nullable = true)
	private String observacoes;
	
	// Campo 23
	@Column(name = "instrutor", nullable = true)
	private String instrutor;
	
	// Campo 24
	@Column(name = "turma_fechada", nullable = false)
	private boolean turmaFechada;
	
	// Campo 25
	@Column(name = "matriculas_bloqueadas", nullable = false)
	private boolean matriculasBloqueadas;
	
	
	// Campo 26
	@ManyToOne // muitos contatos  para 1 empresa
	@JoinColumn(name = "idcurso", nullable = true) // O JoinColumn é para mapeamento de chave estrangeira//
	private Curso curso;
    
	@OneToMany(mappedBy = "turmas") //1 Empresa tem muitos Funcionários
	private List<Matriculas> matricula;
	


}
