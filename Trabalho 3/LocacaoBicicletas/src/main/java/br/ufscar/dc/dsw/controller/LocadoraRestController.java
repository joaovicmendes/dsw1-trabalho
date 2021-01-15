package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@RestController
public class LocadoraRestController {
	
//	@Autowired
//	private IClienteService serviceCliente;
//	
//	@Autowired
//	private ILocacaoService serviceLocacao;
//	
	@Autowired
	private ILocadoraService serviceLocadora;
	
	@PostMapping(path = "/locadoras")
	@ResponseBody
	public ResponseEntity<List<Locadora>> lista(@RequestBody JSONObject json) {
		return null;
	}

	@GetMapping(path = "/locadoras")
	public ResponseEntity<List<Locadora>> lista() {
		List<Locadora> lista = serviceLocadora.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/locadoras/{id}")
	public ResponseEntity<Locadora> listaPorId(@PathVariable("id") Long id) {
		return null;
	}
	
	@GetMapping(path = "/locadoras/cidades/{nome}")
	public ResponseEntity<List<Locadora>> listaPorId(@PathVariable("nome") String nome) {
		return null;
	}
	
	@PutMapping(path = "/locadoras/{id}")
	public ResponseEntity<Locadora> atualiza(@PathVariable("id") Long id, @RequestBody JSONObject json) {
		return null;
	}
	
	@DeleteMapping(path = "/locadoras/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") Long id) {
		return null;
	}
}
