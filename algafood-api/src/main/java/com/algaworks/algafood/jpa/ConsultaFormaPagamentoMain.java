package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = context.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> formasPagamento = formaPagamentoRepository.listarTodas();
		
		for (FormaPagamento formaPagamento : formasPagamento) {
			System.out.printf("%s\n", formaPagamento.getDescricao());
		}

	}

}
