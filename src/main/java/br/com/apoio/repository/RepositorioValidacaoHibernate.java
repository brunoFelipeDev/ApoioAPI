package br.com.apoio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.apoio.model.Cliente;
import br.com.apoio.model.ValidacaoPendente;

@Repository
public class RepositorioValidacaoHibernate extends Repositorio implements RepositorioValidacao {

	@Override
	public Collection<ValidacaoPendente> getValidacoesPendentes() throws SQLException {
		ResultSet rsVal = conexaoSQLite
				.executeQuery("SELECT * FROM cadastroValidacao WHERE UPPER(status) = UPPER('aberto');");

		Collection<ValidacaoPendente> validacoesPendentes = new ArrayList<>();
		ValidacaoPendente validacaoPendente;
		while (rsVal.next()) {
			validacaoPendente = new ValidacaoPendente();
			validacaoPendente.setSistemaDeConversao(rsVal.getString("sistema_conversao"));
			validacaoPendente.setCliente(new Cliente(rsVal.getString("numero_serie"), rsVal.getString("razao_social"),
					rsVal.getString("sistema_conversao"), null));
			validacoesPendentes.add(validacaoPendente);
		}

		return validacoesPendentes;
	}

}
