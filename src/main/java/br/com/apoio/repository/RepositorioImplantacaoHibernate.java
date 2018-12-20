package br.com.apoio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.apoio.conexao.sqlite.ConexaoSQLite;
import br.com.apoio.model.ImplantacoesDoMes;

@Repository
public class RepositorioImplantacaoHibernate implements RepositorioImplantacao {

	@Override
	public ImplantacoesDoMes getImplantacoesDoMes(String dataComeco, String dataFim) throws SQLException {

		String sinalDeConversao = "=";
		String query = "SELECT COUNT(*) AS soma FROM validacao_implantacao  WHERE conversao " + sinalDeConversao
				+ " 'Sem conversão' AND status = 'Fechado' AND data_imp  BETWEEN '" + dataComeco + "' AND '" + dataFim
				+ "'";

		ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
		ResultSet resultSetSemConversao = conexaoSQLite.executeQuery(query);

		ImplantacoesDoMes implantacoesDoMes = new ImplantacoesDoMes();
		while (resultSetSemConversao.next()) {
			implantacoesDoMes.setSemConversao(resultSetSemConversao.getInt("soma"));
		}
		resultSetSemConversao.close();

		sinalDeConversao = "<>";
		ResultSet resultSetComConversao = conexaoSQLite.executeQuery(query);
		while (resultSetComConversao.next()) {
			implantacoesDoMes.setComConversao(resultSetComConversao.getInt("soma"));
		}
		resultSetComConversao.close();

		return implantacoesDoMes;
	}
}
