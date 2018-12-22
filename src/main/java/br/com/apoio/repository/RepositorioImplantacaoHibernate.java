package br.com.apoio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.apoio.model.ImplantacoesDoMes;

@Repository
public class RepositorioImplantacaoHibernate extends Repositorio implements RepositorioImplantacao {
	


	@Override
	public ImplantacoesDoMes getImplantacoesDoMes(String dataComeco, String dataFim) throws SQLException {

		ResultSet rsSemConversao = conexaoSQLite
				.executeQuery(getQueryConsultaImplatacoesDoMes("=", dataComeco, dataFim));

		ImplantacoesDoMes implantacoesDoMes = new ImplantacoesDoMes();
		if (rsSemConversao.next())
			implantacoesDoMes.setQtdSemConversao(rsSemConversao.getInt("soma"));

		rsSemConversao.close();

		ResultSet resultSetComConversao = conexaoSQLite
				.executeQuery(getQueryConsultaImplatacoesDoMes("<>", dataComeco, dataFim));
		if (resultSetComConversao.next())
			implantacoesDoMes.setQtdComConversao(resultSetComConversao.getInt("soma"));

		resultSetComConversao.close();

		return implantacoesDoMes;
	}

	public String getQueryConsultaImplatacoesDoMes(String parametro, String dataComeco, String dataFim) {
		return "SELECT COUNT(*) AS soma FROM validacao_implantacao  WHERE conversao " + parametro
				+ " 'Sem conversão' AND status = 'Fechado' AND data_imp  BETWEEN '" + dataComeco + "' AND '" + dataFim
				+ "'";
	}

	@Override
	public int getImplantacoesCanceladasDoMes(String dataComeco, String dataFim) throws SQLException {
		String query = "SELECT COUNT(*) as soma FROM validacao_implantacao WHERE status = 'Cancelado' AND data_imp  BETWEEN '"
				+ dataComeco + "' AND '" + dataFim + "';";

		ResultSet resultSetSemConversao = conexaoSQLite.executeQuery(query);

		if (resultSetSemConversao.next())
			return resultSetSemConversao.getInt("soma");
		else
			return 0;
	}

}
