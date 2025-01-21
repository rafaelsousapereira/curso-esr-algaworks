package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Cidade> listarTodas() {
		return this.manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return this.manager.find(Cidade.class, id);
	}

	@Override
	public Cidade adicionar(Cidade cidade) {
		return this.manager.merge(cidade);
	}

	@Override
	public void remover(Cidade cidade) {
		cidade = buscarPorId(cidade.getId());
		this.manager.remove(cidade);
	}

}
