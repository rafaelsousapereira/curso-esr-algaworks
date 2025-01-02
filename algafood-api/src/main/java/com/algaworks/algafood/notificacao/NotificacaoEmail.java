package com.algaworks.algafood.notificacao;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDeNotificacao(NivelUrgencia.COM_PRIORIDADE)
@Component
public class NotificacaoEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
