package br.com.apoio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.apoio.model.Cliente;
import br.com.apoio.model.ImplantacaoPendente;
import br.com.apoio.model.ImplantacoesDoMes;
import br.com.apoio.model.TempoGasto;

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

		ResultSet rsTempoGastoSemConversao = conexaoSQLite.executeQuery(
				"SELECT SUM(tempo_gasto_imp) AS soma FROM validacao_implantacao WHERE conversao = 'Sem conversão' AND status = 'Fechado' AND data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "'");
		TempoGasto tempoGasto = new TempoGasto();
		if (rsTempoGastoSemConversao.next())
			tempoGasto.setTempoGastoSemConversao(rsTempoGastoSemConversao.getInt("soma"));
		rsTempoGastoSemConversao.close();

		ResultSet rsTempoGastoComConversao = conexaoSQLite.executeQuery(
				"SELECT SUM(tempo_gasto_imp) AS soma FROM validacao_implantacao WHERE conversao <> 'Sem conversão' AND status = 'Fechado' AND data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "'");
		if (rsTempoGastoComConversao.next())
			tempoGasto.setTempoGastoComConversao(rsTempoGastoComConversao.getInt("soma"));
		rsTempoGastoComConversao.close();

		ResultSet rsQuantidadeDeAgendamentoGastoComConversao = conexaoSQLite.executeQuery(
				"SELECT SUM(qtd_agendamentos_imp) AS soma FROM validacao_implantacao WHERE conversao <> 'Sem conversão' AND status = 'Fechado' AND data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "'");
		if (rsQuantidadeDeAgendamentoGastoComConversao.next())
			tempoGasto.setAgendamentosGastosComConversao(rsQuantidadeDeAgendamentoGastoComConversao.getInt("soma"));
		rsQuantidadeDeAgendamentoGastoComConversao.close();

		ResultSet rsQuantidadeDeAgendamentoGastoSemConversao = conexaoSQLite.executeQuery(
				"SELECT SUM(qtd_agendamentos_imp) AS soma FROM validacao_implantacao WHERE conversao == 'Sem conversão' AND status = 'Fechado' AND data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "'");
		if (rsQuantidadeDeAgendamentoGastoSemConversao.next())
			tempoGasto.setAgendamentoGastosSemConversao(rsQuantidadeDeAgendamentoGastoSemConversao.getInt("soma"));
		rsQuantidadeDeAgendamentoGastoSemConversao.close();

		implantacoesDoMes.setTempoGasto(tempoGasto);

		ResultSet rsClientesImplantadosDoMes = conexaoSQLite.executeQuery(
				"SELECT * FROM validacao_implantacao WHERE status = 'Fechado' and data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "' ORDER BY data_imp DESC");
		ArrayList<Cliente> clientes = new ArrayList<>();
		while (rsClientesImplantadosDoMes.next()) {
			clientes.add(new Cliente(rsClientesImplantadosDoMes.getString("numero_serie"),
					rsClientesImplantadosDoMes.getString("razao_social"), rsClientesImplantadosDoMes.getString("conversao"), rsClientesImplantadosDoMes.getString("data_imp")));
		}
		implantacoesDoMes.setClientesImplantadosSemCancelamento(clientes);
		rsClientesImplantadosDoMes.close();

		ResultSet rsClientesCanceladosDoMes = conexaoSQLite.executeQuery(
				"SELECT * FROM validacao_implantacao WHERE status = 'Cancelado' and data_imp BETWEEN '"
						+ dataComeco + "' AND '" + dataFim + "' ORDER BY data_imp DESC");
		ArrayList<Cliente> clientesCancelados = new ArrayList<>();
		while (rsClientesCanceladosDoMes.next()) {
			clientesCancelados.add(new Cliente(rsClientesCanceladosDoMes.getString("numero_serie"),
					rsClientesCanceladosDoMes.getString("razao_social"), rsClientesCanceladosDoMes.getString("conversao"), rsClientesCanceladosDoMes.getString("data_imp")));
		}
		implantacoesDoMes.setClientesQueCancelaramNoMes(clientesCancelados);
		rsClientesCanceladosDoMes.close();

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

	@Override
	public Collection<ImplantacaoPendente> getImplantacoesPendentes() throws SQLException {

		ResultSet rsImp = conexaoSQLite.executeQuery(
				"SELECT *FROM validacao_implantacao WHERE data_imp is NULL AND UPPER(status) = UPPER('aberto')");

		Collection<ImplantacaoPendente> implantacoesPendentes = new ArrayList<>();
		ImplantacaoPendente implantacaoPendente;
		while (rsImp.next()) {
			implantacaoPendente = new ImplantacaoPendente();
			implantacaoPendente.setSistemaDeConversao(rsImp.getString("conversao"));
			implantacaoPendente
					.setCliente(new Cliente(rsImp.getString("numero_serie"), rsImp.getString("razao_social"), rsImp.getString("conversao"), rsImp.getString("data_imp")));
			implantacoesPendentes.add(implantacaoPendente);
		}

		return implantacoesPendentes;
	}
}
