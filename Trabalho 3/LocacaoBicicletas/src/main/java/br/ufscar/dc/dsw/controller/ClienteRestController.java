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

import br.ufscar.dc.dsw.domain.Cliente;

@RestController
public class ClienteRestController {
	
//	@Autowired
//	private IClienteService serviceCliente;
//	
//	@Autowired
//	private ILocacaoService serviceLocacao;
//	
//	@Autowired
//	private ILocadoraService serviceLocadora;

	@PostMapping(path = "/clientes")
	@ResponseBody
	public ResponseEntity<List<Cliente>> lista(@RequestBody JSONObject json) {
		return null;
	}
	
	@GetMapping(path = "/clientes")
	public ResponseEntity<List<Cliente>> lista() {
		return null;
	}
	
	@GetMapping(path = "/clientes/{id}")
	public ResponseEntity<Cliente> listaPorId(@PathVariable("id") Long id) {
		return null;
	}
	
	@PutMapping(path = "/clientes/{id}")
	public ResponseEntity<Cliente> atualiza(@PathVariable("id") Long id, @RequestBody JSONObject json) {
		return null;
	}
	
	@DeleteMapping(path = "/clientes/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") Long id) {
		return null;
	}
}
