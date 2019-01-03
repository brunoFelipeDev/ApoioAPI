package br.com.apoio.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apoio.model.ValidacaoPendente;
import br.com.apoio.service.ServicoValidacao;

@RestController
@RequestMapping("/validacao")
@CrossOrigin
public class ValidacaoController {

	@Autowired
	private ServicoValidacao servicoValidacao;

	@GetMapping("/pendente")
	public Collection<ValidacaoPendente> getValidacoesPendentes() throws SQLException {
		return servicoValidacao.getValidacoesPendentes();
	}
}
