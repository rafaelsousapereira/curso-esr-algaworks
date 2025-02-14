package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<Permissao> listarTodas() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao buscarPorId(Long id) {
		return this.manager.find(Permissao.class, id);
	}

	@Override
	public Permissao adicionar(Permissao permissao) {
		return this.manager.merge(permissao);
	}

	@Override
	public void remover(Permissao permissao) {
		permissao = buscarPorId(permissao.getId());
		this.manager.remove(permissao);
	}

}
