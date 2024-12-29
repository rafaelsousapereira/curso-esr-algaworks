package com.algaworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificacao) {
		this.notificador = notificacao;
		
		System.out.println("AtivacaoClienteService: " + notificacao);
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
	}

}
