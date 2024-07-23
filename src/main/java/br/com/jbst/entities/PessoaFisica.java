package br.com.jbst.entities;

import java.time.Instant;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoafisica")
public class PessoaFisica {

	@Id // Campo 1
	@Column(name = "idpessoafisica")
	private UUID idpessoafisica;

	// Campo 2
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datahoracriacao", nullable = false)
	private Instant dataHoraCriacao;

	// Campo 3
	@Column(name = "pessoafisica", length = 100, nullable = false)
	private String pessoafisica;

	// Campo 4
	@Column(name = "rg", length = 100, nullable = true)
	private String rg;

	// Campo 5
	@Column(name = "cpf", length = 100, nullable = true)
	private String cpf;

	// Campo 6
	@Column(name = "telefone_1", length = 100, nullable = false)
	private String telefone_1;

	// Campo 7
	@Column(name = "telefone_2", length = 100, nullable = true)
	private String telefone_2;

	// Campo 8
	@Column(name = "email", length = 100, nullable = true)
	private String email;
	
	// Campo 9
	@Column(name = "senha_sistema", length = 100, nullable = true)
	private String senha_sistema;

	// Campo 10
	@Column(name = "assinatura_pessoafisica", nullable = true)
	private byte[] assinatura_pessoafisica;

	@OneToMany(mappedBy = "pessoafisica")
	private List<Matriculas> matriculas;

	public UUID getId() {
		return idpessoafisica;
	}
	
	@OneToMany(mappedBy = "pessoaFisica")
	private List<FaturamentoPf> faturamentos;
	
	// Campo 11
	@ManyToOne
	@JoinColumn(name = "id_usuario_da_pessoa_fisica") // nome correto da coluna de chave estrangeira na tabela PessoaFisica
	private Usuario usuario;

	
	

}