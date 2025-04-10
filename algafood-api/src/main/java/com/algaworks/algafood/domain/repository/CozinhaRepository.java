package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNome(String nome);
	
	Optional<Cozinha> findByNome(String nome);
	
	boolean existsByNome(String nome);

}
