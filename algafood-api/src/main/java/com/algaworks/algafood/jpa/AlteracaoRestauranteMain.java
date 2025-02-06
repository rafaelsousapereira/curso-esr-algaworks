package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class AlteracaoRestauranteMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		RestauranteRepository restaurantes = context.getBean(RestauranteRepository.class);

		Restaurante restaurante = new Restaurante();
				
		restaurante.setId(2L);
		restaurante.setNome("Shabat Food");
		restaurante.setTaxaFrete(BigDecimal.valueOf(9.5));
		
		restaurantes.salvar(restaurante);
	}

}
