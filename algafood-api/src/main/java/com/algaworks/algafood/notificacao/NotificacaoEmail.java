package com.algaworks.algafood.notificacao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDeNotificacao(NivelUrgencia.COM_PRIORIDADE)
@Component
public class NotificacaoEmail implements Notificador {
	
	public NotificacaoEmail() {
		System.out.println("Notificação REAL");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
