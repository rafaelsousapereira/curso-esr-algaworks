package com.algaworks.di;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.NotificadorSMS;
import com.algaworks.di.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {

		Cliente joao = new Cliente("João", "joao@xyz.com", "199999-9999");
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "119999-9999");
		
//		Notificador notificador = new NotificadorEmail();
		Notificador notificador = new NotificadorSMS();

		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);
		ativacaoCliente.ativar(joao);
		ativacaoCliente.ativar(maria);

	}

}
