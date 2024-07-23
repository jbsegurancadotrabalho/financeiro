package br.com.jbst.controllers;

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

import br.com.jbst.DTO.GetCursoDTO;
import br.com.jbst.DTO.GetFaturamentoDTO;
import br.com.jbst.DTO.GetPedidosDTO;
import br.com.jbst.services.RelatorioFaturamentoEmpresaService;
@RestController
@RequestMapping(value = "/api/relatório-financeiro-empresa")
public class RelatorioFaturamentoEmpresaControllers {
	
	@Autowired
	RelatorioFaturamentoEmpresaService  relatorioService;
	
	
	
	@GetMapping(value = "consultar-relatorio-de-faturamento-empresas")
	public  ResponseEntity<List<GetFaturamentoDTO>> ConsultarFaturamento() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarFaturamentos(toString()));
	                                 }
	
	@GetMapping("{id}")
	public  ResponseEntity<GetFaturamentoDTO> consultarUmFaturamento(@PathVariable("id") UUID id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(relatorioService.consultarUmFaturamento(id));

	}
	
	@GetMapping(value = "consultar-relatorio-de-pedidos-empresas")
	public  ResponseEntity<List<GetPedidosDTO>> ConsultarPedidos() throws Exception{
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body(relatorioService.consultarPedidos());
	                                 }
	
	@GetMapping(value = "/consultar-um-relatorio-de-pedido/{id}")
	public  ResponseEntity<GetPedidosDTO> consultarUmPedido(@PathVariable("id") UUID id) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(relatorioService.consultarUmPedido(id));

	}
	
    @GetMapping("/consultar-faturamento-por-mes-e-ano")
public ResponseEntity<List<GetFaturamentoDTO>> consultarFaturamentoPorMesEAno(
        @RequestParam int mes,
        @RequestParam int ano) throws Exception {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body( relatorioService.consultarFaturamentoPorMesAno(mes, ano));
}
    
    @GetMapping("/consultar-pedidos-por-mes-e-ano")
public ResponseEntity<List<GetPedidosDTO>> consultarPedidosPorMesEAno(
        @RequestParam int mes,
        @RequestParam int ano) throws Exception {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body( relatorioService.consultarPedidosPorMesAno(mes, ano));
}
    @GetMapping("/faturamento-empresa-abertos")
    public ResponseEntity<List<GetFaturamentoDTO>> consultarFaturamentosAbertos() throws Exception {
        List<GetFaturamentoDTO> faturamentosAbertos = relatorioService.consultarFaturamentosAberto(); // sem parâmetro
        return ResponseEntity.ok(faturamentosAbertos);
    }

    @GetMapping("/pedidos-empresa-abertos")
    public ResponseEntity<List<GetPedidosDTO>> consultarPedidosAbertos() {
        List<GetPedidosDTO> pedidosAbertos = relatorioService.consultarPedidosAbertos();
        return new ResponseEntity<>(pedidosAbertos, HttpStatus.OK);
    }


}
