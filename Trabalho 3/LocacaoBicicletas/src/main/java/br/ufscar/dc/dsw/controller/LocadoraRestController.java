package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Collections;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;


@RestController
public class LocadoraRestController {
	
	@Autowired
	private IUsuarioService service;

	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private ILocacaoService serviceLocacao;
	
	@Autowired
	private ILocadoraService serviceLocadora;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}
	
	private void parse(Locadora locadora, JSONObject json) {
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				locadora.setId(((Integer) id).longValue());
			} else {
				locadora.setId((Long) id);
			}
		}

		locadora.setUsername((String) json.get("username"));
		locadora.setPassword((String) json.get("password"));
		locadora.setRole((String) json.get("role"));
		locadora.setCNPJ((String) json.get("cnpj"));
		locadora.setNome((String) json.get("nome"));
		locadora.setCidade((String) json.get("telefone"));

	}

	@PostMapping(path = "/locadoras")
	@ResponseBody
	public ResponseEntity<Locadora> lista(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Locadora locadora = new Locadora();
				parse(locadora, json);
				service.salvar(locadora);
				return ResponseEntity.ok(locadora);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
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
		Locadora locadora = serviceLocadora.buscarPorId(id);
		if (locadora == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locadora);
	}
	
	@GetMapping(path = "/locadoras/cidades/{nome}")
		public ResponseEntity<List<Locadora>> listaPorNome(@PathVariable("nome") String nome) {
			List<Locadora> locadoras = serviceLocadora.buscarPorCidade(nome);
			if (locadoras == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(locadoras);
	}
	
	@PutMapping(path = "/locadoras/{id}")
	public ResponseEntity<Locadora> atualiza(@PathVariable("id") Long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Locadora locadora = serviceLocadora.buscarPorId(id);
				if (locadora == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(locadora, json);
					service.salvar(locadora);
					return ResponseEntity.ok(locadora);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@DeleteMapping(path = "/locadoras/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") Long id) {
		Locadora locadora = serviceLocadora.buscarPorId(id);
		if (locadora == null) {
			return ResponseEntity.notFound().build();
		} else if (!locadora.getLocacoes().isEmpty()) {
			return ResponseEntity.ok(false);
		} else {
			service.excluir(id);
			return ResponseEntity.ok(true);
		}
	}
}
