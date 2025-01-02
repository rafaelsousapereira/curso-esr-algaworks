package com.algaworks.algafood.di.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.notificacao.NivelUrgencia;
import com.algaworks.algafood.notificacao.Notificador;
import com.algaworks.algafood.notificacao.TipoDeNotificacao;

@Component
public class AtivacaoClienteService {

	@TipoDeNotificacao(NivelUrgencia.COM_PRIORIDADE)
	@Autowired
	private Notificador notificador;
	
	@PostConstruct
	public void init() {
		System.out.println("INIT " + notificador);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
	}

}
