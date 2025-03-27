package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> consultarPorNome(String nome) {
		return cozinhaRepository.findTodasByNome(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> consultarUnicaPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> consultarPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> consultarPorNome(String nome, Long cozinhaId) {
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> consultarPrimeiroPorNome(String nome) {
		return restauranteRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/dois-primeiro-por-nome")
	public List<Restaurante> consultarDoisPrimeirosPorNome(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/count-by-cozinha-id")
	public int contarRestauratesPorIdCozinha(Long cozinhaId) {
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("/cozinhas/exists-por-nome")
	public boolean consultarExisteCozinhaPorNome(String nome) {
		return cozinhaRepository.existsByNome(nome);
	}
	
	@GetMapping("/restaurantes/por-nome-taxa-frete")
	public List<Restaurante> restaurantePorNomePorFrete(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratis(String nome) {
		return restauranteRepository.findComFreteGratis(nome);
	}
	
}
