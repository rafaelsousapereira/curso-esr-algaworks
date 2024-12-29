package com.algaworks.di.service;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.Produto;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.NotificadorSMS;

public class EmissaoNotaFiscalService {
	
	private Notificador notificador;

	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void emitir(Cliente cliente, Produto produto) {
		// TODO: emite nota fical aqui...
		
		this.notificador.notificar(cliente, "Nota fical do produto"
				+ produto.getNome() + " foi emitida!");
	}
}
