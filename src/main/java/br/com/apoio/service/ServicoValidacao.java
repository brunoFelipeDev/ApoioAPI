package br.com.apoio.service;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apoio.model.ValidacaoPendente;
import br.com.apoio.repository.RepositorioValidacao;

@Service
public class ServicoValidacao {

	@Autowired
	private RepositorioValidacao repositorioValidacao;

	public Collection<ValidacaoPendente> getValidacoesPendentes() throws SQLException {
		return repositorioValidacao.getValidacoesPendentes();
	}
}
