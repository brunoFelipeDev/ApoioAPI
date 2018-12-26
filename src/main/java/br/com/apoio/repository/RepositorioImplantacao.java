package br.com.apoio.repository;

import java.sql.SQLException;

import br.com.apoio.model.ImplantacoesDoMes;

public interface RepositorioImplantacao {

	ImplantacoesDoMes getImplantacoesDoMes(String dataComeco, String dataFim) throws SQLException;
	
	int getImplantacoesCanceladasDoMes(String dataComeco, String dataFim) throws SQLException;
	
}
