package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class NotificacaoEmail implements Notificador {
	
	public NotificacaoEmail() {
		System.out.println("NotificacaoEmail");
	}
		
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do endereço %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
