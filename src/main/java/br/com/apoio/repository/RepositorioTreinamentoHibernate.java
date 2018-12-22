package br.com.apoio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.apoio.model.Treinamento;
import br.com.apoio.model.TreinamentosDoMes;

@Repository
public class RepositorioTreinamentoHibernate extends Repositorio implements RepositorioTreinamento {

	@Override
	public TreinamentosDoMes getInformacoesDosTreinamentosDoMes(String dataComeco, String dataFim) throws SQLException {

		ResultSet rsSit = conexaoSQLite
				.executeQuery("SELECT COUNT(*) AS soma FROM treinamento where treinamentoSIT = '1' and dia BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "' ");

		TreinamentosDoMes treinamentosDoMes = new TreinamentosDoMes();
		if (rsSit.next())
			treinamentosDoMes.setQtdTreinamentosRealizadosParaClientesDoSit(rsSit.getInt("soma"));
		rsSit.close();

		ResultSet rsSup = conexaoSQLite
				.executeQuery("SELECT COUNT(*) AS soma FROM treinamento where treinamentoSUP = '1' and dia BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "' ");
		if (rsSup.next())
			treinamentosDoMes.setQtdTreinamentosRealizadosParaClientesDoSup(rsSup.getInt("soma"));
		rsSup.close();

		return treinamentosDoMes;
	}

	@Override
	public Collection<Treinamento> getUltimosVinteTreinamentos() throws SQLException {
		ResultSet rsTreinamento = conexaoSQLite.executeQuery("SELECT *FROM treinamento ORDER BY id desc LIMIT 20;");

		Collection<Treinamento> treinamentos = new ArrayList<>();
		Treinamento treinamento;
		int posicao = 1;
		while (rsTreinamento.next()) {
			treinamento = new Treinamento();
			treinamento.setId(posicao);
			treinamento.setRazaoSocial(rsTreinamento.getString("razaosocial"));
			treinamento.setDuracao(rsTreinamento.getInt("duracao"));
			treinamento.setFuncaoTreinada(rsTreinamento.getString("funcaotreinada"));
			treinamento.setTecnicoResponsavel(rsTreinamento.getString("instrutor"));
			treinamento.setData(rsTreinamento.getString("dia"));
			posicao ++;

			treinamentos.add(treinamento);
		}

		return treinamentos;
	}
}
