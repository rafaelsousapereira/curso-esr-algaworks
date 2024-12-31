package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	@Autowired
	public AtivacaoClienteService(Notificador notificacao) {
		this.notificador = notificacao;
	}
	
	public AtivacaoClienteService(String qualquer) {
		
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
	}

	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}

}
