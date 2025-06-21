package com.algaworks.algafood.domain.exception;

public class EstadoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	private static final String MGS_ESTADO_NAO_ENCONTRADO = "Não existe um cadastro de estado com código %d";
	
	public EstadoNaoEncontradaException( String mensagem) {
		super(mensagem);
	}

	public EstadoNaoEncontradaException(Long estadoId) {
		this(String.format(MGS_ESTADO_NAO_ENCONTRADO, estadoId));
	}
}
