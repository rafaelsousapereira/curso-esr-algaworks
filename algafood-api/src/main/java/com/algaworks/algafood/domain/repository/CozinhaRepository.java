package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {
	
	List<Cozinha> listarTodas();
	Cozinha buscarPorId(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);

}
