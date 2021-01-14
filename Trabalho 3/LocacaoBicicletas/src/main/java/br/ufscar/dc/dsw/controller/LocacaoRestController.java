package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ufscar.dc.dsw.domain.Locacao;

public class LocacaoRestController {
//	@Autowired
//	private IClienteService serviceCliente;
//	
//	@Autowired
//	private ILocacaoService serviceLocacao;
//	
//	@Autowired
//	private ILocadoraService serviceLocadora;
	
	@GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		return null;
	}
	
	@GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> listaPorId(@PathVariable("id") Long id) {
		return null;
	}
	
	@GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<Locacao>> listaPorIdCliente(@PathVariable("id") Long id) {
		return null;
	}
	
	@GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<Locacao>> listaPorIdLocadora(@PathVariable("id") Long id) {
		return null;
	}
}
