package br.com.jbst.entities;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "empresa")
public class Empresa {
	
@Id
@Column(name = "idempresa")
private UUID idEmpresa;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "datahoracriacao", nullable = false) 
private Instant dataHoraCriacao;

@Column(name = "razaosocial", length = 100, nullable = false)
private String razaosocial;

@Column(name = "nomefantasia", length = 20, nullable = false)
private String nomefantasia;

@Column(name = "cnpj", length = 100, nullable = false)
private String cnpj;

@Column(name = "status", length = 100, nullable = false)
private String status;

@Column(name = "inscricaoestadual", length = 100, nullable = true)
private String inscricaoestadual;

@Column(name = "inscricaomunicipal", length = 100, nullable = true)
private String inscricaomunicipal;

@Column(name = "responsavel_sistema", length = 100, nullable = true)
private String responsavel_sistema;

@Column(name = "email_usuario", length = 100, nullable = true)
private String email_usuario;

@Column(name = "senha_sistema", length = 100, nullable = true)
private String senha_sistema;

@Column(name = "telefone_responsavel", length = 100, nullable = true)
private String telefone_responsavel;

	
@Column(name = "assinatura")
private byte[] logo;

@OneToMany(mappedBy = "empresa")
private List<Faturamento> faturamentos;

@OneToMany(mappedBy = "empresa") //1 Empresa tem muitos Funcionários
private List<Funcionario> funcionarios;

public static Stream<Pedidos> stream() {
	return null;
}

@ManyToOne
@JoinColumn(name = "id_usuario")
private Usuario usuario;

}
