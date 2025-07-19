package com.algaworks.algafood.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.exceptionhandler.Problema;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public Cidade buscarPorId(@PathVariable Long cidadeId) {
		return cadastroCidadeService.buscarOuFalhar(cidadeId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		try {
			return cadastroCidadeService.salvar(cidade);
		} catch (EstadoNaoEncontradaException ex) {
			throw new NegocioException(ex.getMessage(), ex);
		}
	}

	@PutMapping("/{cidadeId}")
	public Cidade alterar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cadastroCidadeService.buscarOuFalhar(cidadeId);

			BeanUtils.copyProperties(cidade, cidadeAtual, "id");

			return cadastroCidadeService.salvar(cidadeAtual);
		} catch (EstadoNaoEncontradaException ex) {
			throw new NegocioException(ex.getMessage(), ex);
		}
	}

	@DeleteMapping("/{cidadeId}")
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidadeService.remover(cidadeId);
	}

}
