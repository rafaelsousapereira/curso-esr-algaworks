package com.algaworks.algafood.notificacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDeNotificacao(NivelUrgencia.COM_PRIORIDADE)
@Component
public class NotificacaoEmail implements Notificador {
	
	@Autowired
	private NotificacaoProperties properties;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + this.properties.getHostServidor());
		System.out.println("Port: " + this.properties.getPortaServidor());
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
