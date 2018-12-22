package br.com.apoio.repository;

import java.sql.SQLException;
import java.util.Collection;

import br.com.apoio.model.Treinamento;
import br.com.apoio.model.TreinamentosDoMes;

public interface RepositorioTreinamento {

	
	TreinamentosDoMes getInformacoesDosTreinamentosDoMes(String dataComeco, String dataFim) throws SQLException;
	
	Collection<Treinamento> getUltimosVinteTreinamentos() throws SQLException;
}
