package br.com.jbst.services;

import java.math.BigDecimal;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbst.DTO.GetCobrancaFaturamentoDTO;
import br.com.jbst.DTO.GetCursoDTO;
import br.com.jbst.DTO.GetEmpresaDTOs;
import br.com.jbst.DTO.GetFaturamentoDTO;
import br.com.jbst.DTO.GetFaturamentopfDto;
import br.com.jbst.DTO.GetFuncaoDTOs;
import br.com.jbst.DTO.GetFuncionarioDTOs;
import br.com.jbst.DTO.GetMatriculaFaturamentoPfDTO;
import br.com.jbst.DTO.GetPedidosDTO;
import br.com.jbst.DTO.GetPessoaFisicaDTO;
import br.com.jbst.DTO.GetTurmasDTO;
import br.com.jbst.DTO.RelatorioFaturamentoPfDto;
import br.com.jbst.DTO.RelatorioMatriculaDTO;
import br.com.jbst.entities.Cobranca;
import br.com.jbst.entities.Curso;
import br.com.jbst.entities.Empresa;
import br.com.jbst.entities.Faturamento;
import br.com.jbst.entities.FaturamentoPf;
import br.com.jbst.entities.Funcao;
import br.com.jbst.entities.Funcionario;
import br.com.jbst.entities.Matriculas;
import br.com.jbst.entities.Pedidos;
import br.com.jbst.entities.PessoaFisica;
import br.com.jbst.entities.Turmas;
import br.com.jbst.repositories.ICobrancaRepository;
import br.com.jbst.repositories.ICursoRepository;
import br.com.jbst.repositories.IEmpresaRepository;
import br.com.jbst.repositories.IFaturamentoPfRepository;
import br.com.jbst.repositories.IFaturamentoRepository;
import br.com.jbst.repositories.IFuncaoRepository;
import br.com.jbst.repositories.IFuncionarioRepository;
import br.com.jbst.repositories.IMatriculasRepository;
import br.com.jbst.repositories.IPedidosRepository;
import br.com.jbst.repositories.IPessoaFisicaRepository;
import br.com.jbst.repositories.ITurmasRepository;
import jakarta.transaction.Transactional;

@Service
public class RelatorioFaturamentoServices {
	@Autowired
	ICursoRepository cursoRepository;
	@Autowired
	IEmpresaRepository empresaRepository;
	@Autowired
	IFuncionarioRepository funcionarioRepository;
	@Autowired
	IFuncaoRepository funcaoRepository;
	@Autowired
	IMatriculasRepository matriculasRepository;
	@Autowired
	IPessoaFisicaRepository pessoafisicaRepository;
	@Autowired
	ITurmasRepository turmasRepository;
	@Autowired
	IFaturamentoPfRepository faturamentopfRepository;
	@Autowired
	IFaturamentoRepository faturamentoRepository;
	@Autowired
	IPedidosRepository pedidosRepository;
	@Autowired
	ICobrancaRepository cobrancaRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<GetCobrancaFaturamentoDTO> consultarCobranças(String cobranca) throws Exception {
		List<Cobranca> registro = cobrancaRepository.findAll();
		List<GetCobrancaFaturamentoDTO> lista = modelMapper.map(registro,
				new TypeToken<List<GetCobrancaFaturamentoDTO>>() {
				}.getType());
		return lista;
	}

	public List<GetCursoDTO> consultarCursos(String curso) throws Exception {
		List<Curso> cursos = cursoRepository.findAll();
		List<GetCursoDTO> lista = modelMapper.map(cursos, new TypeToken<List<GetCursoDTO>>() {
		}.getType());
		return lista;
	}

	public List<GetEmpresaDTOs> consultarEmpresas(String empresa) throws Exception {
		List<Empresa> empresas = empresaRepository.findAll();
		List<GetEmpresaDTOs> lista = modelMapper.map(empresas, new TypeToken<List<GetEmpresaDTOs>>() {
		}.getType());
		return lista;
	}

	public List<GetFuncionarioDTOs> consultarFuncionarios(String funcionarios) throws Exception {
		List<Funcionario> funcionario = funcionarioRepository.findAll();
		List<GetFuncionarioDTOs> lista = modelMapper.map(funcionario, new TypeToken<List<GetFuncionarioDTOs>>() {
		}.getType());
		return lista;
	}

	public List<GetFuncaoDTOs> consultarFuncao(String funcao) throws Exception {
		List<Funcao> funcoes = funcaoRepository.findAll();
		List<GetFuncaoDTOs> lista = modelMapper.map(funcoes, new TypeToken<List<GetFuncaoDTOs>>() {
		}.getType());
		return lista;
	}

	public List<GetMatriculaFaturamentoPfDTO> consultarMatriculas(String matriculas) throws Exception {
		List<Matriculas> matricula = matriculasRepository.findAll();
		List<GetMatriculaFaturamentoPfDTO> lista = modelMapper.map(matricula,
				new TypeToken<List<GetMatriculaFaturamentoPfDTO>>() {
				}.getType());
		return lista;
	}

	public List<GetPessoaFisicaDTO> consultarPessoaFisica(String pessoafisica) throws Exception {
		List<PessoaFisica> pessoafisicas = pessoafisicaRepository.findAll();
		List<GetPessoaFisicaDTO> lista = modelMapper.map(pessoafisicas, new TypeToken<List<GetPessoaFisicaDTO>>() {
		}.getType());
		return lista;
	}

	public List<GetTurmasDTO> consultarTurmas(String turmas) throws Exception {
		List<Turmas> turma = turmasRepository.findAll();
		List<GetTurmasDTO> lista = modelMapper.map(turma, new TypeToken<List<GetTurmasDTO>>() {
		}.getType());
		return lista;
	}

	public List<GetFaturamentopfDto> consultarFaturamentospf(String data_inicio) throws Exception {
		List<FaturamentoPf> faturamentopf = faturamentopfRepository.findAll();
		List<GetFaturamentopfDto> lista = mapFaturamentopfListToDTO(faturamentopf);
		return lista;
	}

	private List<GetFaturamentopfDto> mapFaturamentoListToDTO(List<FaturamentoPf> faturamentoList) {
		return faturamentoList.stream().map(this::mapFaturamentoToDTO).collect(Collectors.toList());
	}

	private GetFaturamentopfDto mapFaturamentoToDTO(FaturamentoPf faturamento) {
		ModelMapper modelMapper = new ModelMapper();
		GetFaturamentopfDto dto = modelMapper.map(faturamento, GetFaturamentopfDto.class);
		return dto;
	}



	public List<GetFaturamentopfDto> consultarFaturamentosAberto() throws Exception {
		List<FaturamentoPf> faturamentoList = faturamentopfRepository.findByFaturaFechada(false);
		return mapFaturamentoListToDTO(faturamentoList);
	}

	private List<GetFaturamentopfDto> mapFaturamentopfListToDTO(List<FaturamentoPf> faturamentopfList) {
		return faturamentopfList.stream().map(this::mapFaturamentoToDTO).collect(Collectors.toList());
	}



	private List<GetCobrancaFaturamentoDTO> mapCobrancasToDTO(List<Cobranca> cobrancas) {
		return cobrancas.stream().map(this::mapSingleCobrancaToDTO).collect(Collectors.toList());
	}

	private GetCobrancaFaturamentoDTO mapSingleCobrancaToDTO(Cobranca cobranca) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cobranca, GetCobrancaFaturamentoDTO.class);
	}

	private GetPessoaFisicaDTO mapPessoaFisicaToDTO(PessoaFisica pessoaFisica) {
		if (pessoaFisica == null) {
			return null; // Or create and return a default DTO if needed
		}
		ModelMapper modelMapper = new ModelMapper();
		GetPessoaFisicaDTO pessoaFisicaDTO = modelMapper.map(pessoaFisica, GetPessoaFisicaDTO.class);
		;
		return pessoaFisicaDTO;
	}


	private List<RelatorioMatriculaDTO> mapMatriculasToDTO(List<Matriculas> matriculas) {
		return matriculas.stream().map(this::mapMatriculaToDTO).collect(Collectors.toList());
	}

	private RelatorioMatriculaDTO mapMatriculaToDTO(Matriculas matricula) {
		ModelMapper modelMapper = new ModelMapper();
		RelatorioMatriculaDTO dto = modelMapper.map(matricula, RelatorioMatriculaDTO.class);
		GetPessoaFisicaDTO pessoaFisicaDTO = mapPessoaFisicaToDTO(matricula.getPessoafisica());
		dto.setPessoafisica(pessoaFisicaDTO);

		// Se houver uma entidade Funcionario associada, mapeie também
		if (matricula.getFuncionario() != null) {
			GetFuncionarioDTOs funcionarioDTO = mapFuncionarioToDTO(matricula.getFuncionario());
			dto.setFuncionario(funcionarioDTO);
		}

		// Se houver uma entidade Turmas associada, mapeie também
		if (matricula.getTurmas() != null) {
			GetTurmasDTO turmasDTO = mapTurmasToDTO(matricula.getTurmas());
			dto.setTurmas(turmasDTO);
		}

		return dto;
	}

	private GetTurmasDTO mapTurmasToDTO(Turmas turmas) {
		ModelMapper modelMapper = new ModelMapper();
		GetTurmasDTO turmasDTO = modelMapper.map(turmas, GetTurmasDTO.class);
		return turmasDTO;
	}

	private GetFuncionarioDTOs mapFuncionarioToDTO(Funcionario funcionario) {
		ModelMapper modelMapper = new ModelMapper();
		GetFuncionarioDTOs funcionarioDTO = modelMapper.map(funcionario, GetFuncionarioDTOs.class);
		return funcionarioDTO;
	}

	@Transactional
	public void fecharFaturaManualmente(UUID idFaturamento) {
		Faturamento faturamento = faturamentoRepository.findById(idFaturamento).orElseThrow();
		faturamento.setFaturaFechada(true);
		faturamentoRepository.save(faturamento);
	}

	@Transactional
	public void reabrirFatura(UUID idFaturamento) {
		Faturamento faturamento = faturamentoRepository.findById(idFaturamento).orElseThrow();
		if (!faturamento.isFaturaFechada()) {
			throw new IllegalStateException("A fatura não está fechada para reabrir.");
		}

		faturamento.setFaturaFechada(false);
		faturamentoRepository.save(faturamento);
	}

	@Transactional
	public void fecharPedidoManualmente(UUID idPedido) {
		// Buscar o pedido pelo ID
		Pedidos pedido = pedidosRepository.findById(idPedido)
				.orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

		// Fechar o pedido manualmente
		pedido.setPedidoFechado(true);

		// Salvar as alterações no repositório
		pedidosRepository.save(pedido);
	}

	@Transactional
	public void reabrirPedido(UUID idPedido) {
		Pedidos pedido = pedidosRepository.findById(idPedido)
				.orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

		if (!pedido.isPedidoFechado()) {
			throw new IllegalStateException("O pedido não está fechado para reabrir.");
		}

		// Reabra o pedido
		pedido.setPedidoFechado(false);
		pedido.setMatriculasBloqueadas(false);

		// Atualize outras propriedades ou execute ações necessárias ao reabrir o pedido

		pedidosRepository.save(pedido);
	}

	private int mapCobrancaToDTO(Cobranca cobranca1, Cobranca cobranca2) {
		return 0;
	}

	private <R> R mapFaturamentopfListToDTO(Faturamento faturamento1) {
		return null;
	}

	private <R> R mapFaturamentoToDTO(Faturamento faturamento1) {
		return null;
	}
	
	    private GetPessoaFisicaDTO mapPessoaFisicaToDTO1(PessoaFisica pessoaFisica) {
	        return (pessoaFisica != null) ? modelMapper.map(pessoaFisica, GetPessoaFisicaDTO.class) : null;
	    }
	    
	    public List<GetPessoaFisicaDTO> consultarPessoasFisicas() {
	        List<PessoaFisica> pessoasFisicas = pessoafisicaRepository.findAll();
	        return modelMapper.map(pessoasFisicas, new TypeToken<List<GetPessoaFisicaDTO>>() {}.getType());
	    }

	    

	    public List<GetFaturamentopfDto> findFaturamentoByMesAndAno(int mes, int ano) {
	   		 List<FaturamentoPf> faturamentos = faturamentopfRepository.findFaturamentoByMesAndAno( mes, ano);
	   		    return faturamentos.stream()
	   		            .map(this::convertToFaturamentoPfDto)
	   		            .collect(Collectors.toList());
	   		}

		public List<GetFaturamentopfDto> buscarFaturamentoPorIdUsuario(UUID idUsuario, int mes, int ano) {
		    List<FaturamentoPf> faturamentos = faturamentopfRepository.findByUsuarioIdAndMesAndAno(idUsuario, mes, ano);
		    return faturamentos.stream()
		            .map(this::convertToFaturamentoPfDto)
		            .collect(Collectors.toList());
		}

		private GetFaturamentopfDto convertToFaturamentoPfDto(FaturamentoPf faturamentoPf) {
		    GetFaturamentopfDto dto = modelMapper.map(faturamentoPf, GetFaturamentopfDto.class);
		    
		    return dto;
		} 

		
		  public List<GetFaturamentopfDto> buscarFaturasAbertasPorIdUsuario(UUID idUsuario) {
		        List<FaturamentoPf> faturamentos = faturamentopfRepository.findFaturasAbertasByUsuarioId(idUsuario);
		        return faturamentos.stream()
		                .map(this::convertToFaturamentoPfDto1)
		                .collect(Collectors.toList());
		    }

		    private GetFaturamentopfDto convertToFaturamentoPfDto1(FaturamentoPf faturamentoPf) {
		        GetFaturamentopfDto dto = modelMapper.map(faturamentoPf, GetFaturamentopfDto.class);
		        return dto;
		    }

		 
			

	

		

}


