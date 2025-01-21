package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Estado> listarTodos() {
		return this.manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscarPorId(Long id) {
		return this.manager.find(Estado.class, id);
	}

	@Override
	public Estado adicionar(Estado estado) {
		return this.manager.merge(estado);
	}

	@Override
	public void remover(Estado estado) {
		estado = buscarPorId(estado.getId());
		this.manager.remove(estado);
	}

}
