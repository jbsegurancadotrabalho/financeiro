package br.com.jbst.controllers;

import java.util.Collections;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbst.DTO.GetCobrancaFaturamentoDTO;
import br.com.jbst.DTO.GetCursoDTO;
import br.com.jbst.DTO.GetEmpresaDTOs;
import br.com.jbst.DTO.GetFaturamentopfDto;
import br.com.jbst.DTO.GetFuncaoDTOs;
import br.com.jbst.DTO.GetFuncionarioDTOs;
import br.com.jbst.DTO.GetMatriculaFaturamentoPfDTO;
import br.com.jbst.DTO.GetPessoaFisicaDTO;
import br.com.jbst.DTO.GetTurmasDTO;
import br.com.jbst.services.RelatorioFaturamentoServices;

@RestController
@RequestMapping(value = "/api/relatório-financeiro")
public class RelatorioFaturamentoControllers {
	
	@Autowired
	RelatorioFaturamentoServices  relatorioService;
	
	@GetMapping(value = "consultar-cobrancas")
	public  ResponseEntity<List<GetCobrancaFaturamentoDTO>> ConsultarCobrancas() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarCobranças(toString()));
	                                 }
	@GetMapping(value = "consultar-cursos")
	public  ResponseEntity<List<GetCursoDTO>> ConsultarCursos() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarCursos(toString()));
	                                 }
	
	@GetMapping(value = "consultar-empresas")
	public  ResponseEntity<List<GetEmpresaDTOs>> ConsultarEmpresas() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarEmpresas(toString()));
	                                 }
	
	@GetMapping(value = "consultar-funcionarios")
	public  ResponseEntity<List<GetFuncionarioDTOs>> ConsultarFuncionarios() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarFuncionarios(toString()));
	                                 }
	@GetMapping(value = "consultar-funcoes")
	public  ResponseEntity<List<GetFuncaoDTOs>> ConsultarFuncoes() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarFuncao(toString()));
	                                 }
	


	
	@GetMapping(value = "consultar-turmas")
	public  ResponseEntity<List<GetTurmasDTO>> ConsultarTurmas() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarTurmas(toString()));
	                                 }
	

	@GetMapping(value = "consultar-pessoa-fisicas")
	 public List<GetPessoaFisicaDTO> consultarPessoasFisicas() {
        return relatorioService.consultarPessoasFisicas();
    }
	
	@GetMapping(value = "consultar-faturamento-pessoa-fisica")
	public  ResponseEntity<List<GetFaturamentopfDto>> ConsultarFaturamentoPessoaFisica() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarFaturamentospf(toString()));
	                                 }
	
	
	@GetMapping(value = "consultar-matriculas")
	public  ResponseEntity<List<GetMatriculaFaturamentoPfDTO>> ConsultarMatriculas() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarMatriculas(toString()));
	                                 }

  
    
    @GetMapping("/pessoa-fisica-aberto")
    public List<GetFaturamentopfDto> consultarFaturamentosAberto() {
        try {
            return relatorioService.consultarFaturamentosAberto();
        } catch (Exception e) {
            // Aqui você pode lidar com exceções, como retornar uma resposta de erro HTTP adequada
            e.printStackTrace();
            return Collections.emptyList(); // Retorna uma lista vazia em caso de erro
        }
    }
    

    @GetMapping("/api/relatorio-financeiro/faturamento/usuario-mes-ano")
    public List<GetFaturamentopfDto> buscarFaturamentoPorIdUsuario(
            @RequestParam UUID idUsuario, 
            @RequestParam int mes, 
            @RequestParam int ano
    ) {
        return relatorioService.buscarFaturamentoPorIdUsuario(idUsuario, mes, ano);
    }
    
    @GetMapping("/usuario/{idUsuario}/faturas-abertas")
    public ResponseEntity<List<GetFaturamentopfDto>> buscarFaturasAbertasPorIdUsuario(@PathVariable UUID idUsuario) {
        List<GetFaturamentopfDto> faturasAbertas = relatorioService.buscarFaturasAbertasPorIdUsuario(idUsuario);
        return new ResponseEntity<>(faturasAbertas, HttpStatus.OK);
    }
	
    @GetMapping("/api/relatorio-financeiro/faturamento/mes-ano")
    public List<GetFaturamentopfDto> findFaturamentoByMesAndAno(@RequestParam int mes, @RequestParam int ano) {
        return relatorioService.findFaturamentoByMesAndAno(mes, ano);
    }
}
