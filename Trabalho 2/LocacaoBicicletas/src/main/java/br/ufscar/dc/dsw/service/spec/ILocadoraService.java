package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locadora;

public interface ILocadoraService {
	Locadora buscarPorCNPJ(String CNPJ);

	List<Locadora> buscarPorCidade(String cidade);
}
