package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Service
@Transactional(readOnly = false)
public class LocadoraService implements ILocadoraService {

	@Autowired
	ILocadoraDAO dao;

	@Transactional(readOnly = true)
	public Locadora buscarPorCNPJ(String CNPJ) {
		return dao.findByCNPJ(CNPJ);
	}

	@Transactional(readOnly = true)
	public List<Locadora> buscarPorCidade(String cidade) {
		return dao.findByCidade(cidade);
	}
}
