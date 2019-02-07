package br.com.apoio.repository;

import java.sql.SQLException;
import java.util.Collection;

import br.com.apoio.model.ImplantacaoPendente;
import br.com.apoio.model.ImplantacoesDoMes;

public interface RepositorioImplantacao {

	ImplantacoesDoMes getImplantacoesDoMes(String dataComeco, String dataFim) throws SQLException;

	int getImplantacoesCanceladasDoMes(String dataComeco, String dataFim) throws SQLException;

	Collection<ImplantacaoPendente> getImplantacoesPendentes() throws SQLException;
	
}
