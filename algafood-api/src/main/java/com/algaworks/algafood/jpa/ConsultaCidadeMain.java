package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = context.getBean(CidadeRepository.class);

		List<Cidade> cidades = cidadeRepository.listarTodas();

		for (Cidade cidade : cidades) {
			System.out.printf("%s\n", cidade.getNome());
		}

	}

}
