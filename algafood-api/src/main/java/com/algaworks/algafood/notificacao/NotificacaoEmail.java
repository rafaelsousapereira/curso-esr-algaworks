package com.algaworks.algafood.notificacao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDeNotificacao(NivelUrgencia.COM_PRIORIDADE)
@Component
public class NotificacaoEmail implements Notificador {
	
	@Value("${notificador.email.host-servidor}")
	private String host;
	
	@Value("${notificador.email.porta-servidor}")
	private String port;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + this.host);
		System.out.println("Port: " + this.port);
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
