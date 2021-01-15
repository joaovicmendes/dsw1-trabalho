package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@RestController
public class LocacaoRestController {
	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private ILocacaoService serviceLocacao;
	
	@Autowired
	private ILocadoraService serviceLocadora;
	
	@GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		List<Locacao> lista = serviceLocacao.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/locacoes/{id}")
	public ResponseEntity<Locacao> listaPorId(@PathVariable("id") Long id) {
		Locacao locacao = serviceLocacao.buscarPorId(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
	}
	
	@GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<Locacao>> listaPorIdCliente(@PathVariable("id") Long id) {
		Cliente cliente = serviceCliente.buscarPorId(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		List<Locacao> lista = serviceLocacao.buscarPorCliente(cliente);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<Locacao>> listaPorIdLocadora(@PathVariable("id") Long id) {
		Locadora locadora = serviceLocadora.buscarPorId(id);
		if (locadora == null) {
			return ResponseEntity.notFound().build();
		}
		List<Locacao> lista = serviceLocacao.buscarPorLocadora(locadora);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
}
