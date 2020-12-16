package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, Long>{

	Locadora findByCNPJ(String CNPJ);

	Locadora findById(long id);

	List<Locadora> findAll();

	List<Locadora> findByCidade(String cidade);
}
