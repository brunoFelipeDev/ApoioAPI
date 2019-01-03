package br.com.apoio.repository;

import java.sql.SQLException;
import java.util.Collection;

import br.com.apoio.model.ValidacaoPendente;

public interface RepositorioValidacao {

	Collection<ValidacaoPendente> getValidacoesPendentes() throws SQLException;

}
