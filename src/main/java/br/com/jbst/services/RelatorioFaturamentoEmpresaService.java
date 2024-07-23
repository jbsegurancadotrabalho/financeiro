package br.com.jbst.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbst.DTO.GetCobrancaFaturamentoDTO;
import br.com.jbst.DTO.GetEmpresaDTOs;
import br.com.jbst.DTO.GetFaturamentoDTO;
import br.com.jbst.DTO.GetPedidosDTO;
import br.com.jbst.DTO.RelatorioMatriculaDTO;
import br.com.jbst.entities.Cobranca;
import br.com.jbst.entities.Empresa;
import br.com.jbst.entities.Faturamento;
import br.com.jbst.entities.Matriculas;
import br.com.jbst.entities.Pedidos;
import br.com.jbst.repositories.ICobrancaRepository;
import br.com.jbst.repositories.ICursoRepository;
import br.com.jbst.repositories.IEmpresaRepository;
import br.com.jbst.repositories.IFaturamentoRepository;
import br.com.jbst.repositories.IFuncaoRepository;
import br.com.jbst.repositories.IFuncionarioRepository;
import br.com.jbst.repositories.IMatriculasRepository;
import br.com.jbst.repositories.IPedidosRepository;
import br.com.jbst.repositories.ITurmasRepository;

@Service
public class RelatorioFaturamentoEmpresaService {
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
	ITurmasRepository turmasRepository;
	@Autowired
	IFaturamentoRepository faturamentoRepository;
	@Autowired
	IPedidosRepository pedidosRepository;
	@Autowired
	ICobrancaRepository cobrancaRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<GetPedidosDTO> consultarPedidos() throws Exception {
		List<Pedidos> pedidos = pedidosRepository.findAll();
		return pedidos.stream().map(this::mapPedidosToDTO).collect(Collectors.toList());
	}

	public GetPedidosDTO consultarUmPedido(UUID id) throws Exception {
		Optional<Pedidos> registro = pedidosRepository.findById(id);

		if (registro.isPresent()) {
			Pedidos pedidos = registro.get();
			return mapPedidosToDTO(pedidos);
		} else {
			throw new RuntimeException("Pedidos não encontrado");
		}
	}

	public List<GetFaturamentoDTO> consultarFaturamentos(String string) throws Exception {
		List<Faturamento> faturamentoList = faturamentoRepository.findAll();
		return faturamentoList.stream().map(this::mapFaturamentoToDTO).collect(Collectors.toList());
	}
	
	public List<GetFaturamentoDTO> consultarFaturamentosAberto() throws Exception {
	    List<Faturamento> faturamentoList = faturamentoRepository.findFaturamentoByFaturaFechada(false);
	    return faturamentoList.stream().map(this::mapFaturamentoToDTO).collect(Collectors.toList());
	}

	
	
	

	public GetFaturamentoDTO consultarUmFaturamento(UUID id) throws Exception {
		Optional<Faturamento> optionalFaturamento = faturamentoRepository.findById(id);

		if (optionalFaturamento.isPresent()) {
			Faturamento faturamento = optionalFaturamento.get();
			return mapFaturamentoToDTO(faturamento);
		} else {
			throw new RuntimeException("Faturamento não encontrado");
		}
	}

	private GetPedidosDTO mapPedidosToDTO(Pedidos pedidos) {
		GetPedidosDTO dto = modelMapper.map(pedidos, GetPedidosDTO.class);

		if (pedidos.getMatricula() != null) {
			List<RelatorioMatriculaDTO> matriculasDTO = mapMatriculasToDTO(pedidos.getMatricula());
			dto.setMatriculas(matriculasDTO);
		}

		if (pedidos.getCobrancas() != null) {
			List<GetCobrancaFaturamentoDTO> cobrancasDTO = mapCobrancasToDTO(pedidos.getCobrancas());
			dto.setRelatorio(cobrancasDTO);
		}
		if (pedidos.getEmpresa() != null) {
		    GetEmpresaDTOs empresaDTO = mapEmpresaToDTO(pedidos.getEmpresa());
		    dto.setEmpresa(empresaDTO);
		}
		return dto;
	}

	private GetFaturamentoDTO mapFaturamentoToDTO(Faturamento faturamento) {
		GetFaturamentoDTO dto = modelMapper.map(faturamento, GetFaturamentoDTO.class);

		if (faturamento.getMatriculas() != null) {
			List<RelatorioMatriculaDTO> matriculasDTO = mapMatriculasToDTO(faturamento.getMatriculas());
			dto.setMatriculas(matriculasDTO);
		}

		if (faturamento.getCobrancas() != null) {
			List<GetCobrancaFaturamentoDTO> cobrancasDTO = mapCobrancasToDTO(faturamento.getCobrancas());
			dto.setRelatorio(cobrancasDTO);
		}
		
		if (faturamento.getEmpresa() != null) {
		    GetEmpresaDTOs empresaDTO = mapEmpresaToDTO(faturamento.getEmpresa());
		    dto.setEmpresa(empresaDTO);
		}


		return dto;
	}

	private List<RelatorioMatriculaDTO> mapMatriculasToDTO(List<Matriculas> matriculas) {
		return matriculas.stream().map(matricula -> modelMapper.map(matricula, RelatorioMatriculaDTO.class))
				.collect(Collectors.toList());
	}

	private GetEmpresaDTOs mapEmpresaToDTO(Empresa empresa) {
	    return modelMapper.map(empresa, GetEmpresaDTOs.class);
	}


	private List<GetCobrancaFaturamentoDTO> mapCobrancasToDTO(List<Cobranca> cobrancas) {
		return cobrancas.stream().map(cobranca -> modelMapper.map(cobranca, GetCobrancaFaturamentoDTO.class))
				.collect(Collectors.toList());
	}
	
	
	public List<GetFaturamentoDTO> consultarFaturamentoPorMesAno(int mes, int ano) throws Exception {
		List<Faturamento> faturamentoList = faturamentoRepository.findFaturamentoByMesAndAno(mes, ano);
		return faturamentoList.stream().map(this::mapFaturamentoToDTO).collect(Collectors.toList());
	}


	public List<GetPedidosDTO> consultarPedidosPorMesAno(int mes, int ano) throws Exception {
		List<Pedidos> registro = pedidosRepository.findPedidosByMesAndAno(mes, ano);
		return registro.stream().map(this::mapPedidosToDTO).collect(Collectors.toList());
	}
	
	public List<GetPedidosDTO> consultarPedidosAbertos() {
        List<Pedidos> pedidosAbertos = pedidosRepository.findPedidoByPedidoFechado(false);
        return pedidosAbertos.stream().map(this::mapPedidosToDTO1).collect(Collectors.toList());
    }

    private GetPedidosDTO mapPedidosToDTO1(Pedidos pedidos) {
        return modelMapper.map(pedidos, GetPedidosDTO.class);
    }

}
