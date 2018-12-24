package br.com.apoio.service;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apoio.model.Treinamento;
import br.com.apoio.model.TreinamentosDoMes;
import br.com.apoio.repository.RepositorioTreinamento;
import br.com.apoio.utils.UtilData;

@Service
public class ServicoTreinamento {

	@Autowired
	private RepositorioTreinamento repositorioTreinamento;
	
	public TreinamentosDoMes getTreinamentosDoMes() throws SQLException {
		return repositorioTreinamento.getInformacoesDosTreinamentosDoMes(UtilData.getPrimeiroDiaDaDataCompletaDoMesAtual(), UtilData.getUltimoDiaDaDataCompletaDoMesAtual());
	}
	
	public Collection<Treinamento> getUltimosVinteTreinamentos() throws SQLException {
		return repositorioTreinamento.getUltimosVinteTreinamentos();
	}
}
