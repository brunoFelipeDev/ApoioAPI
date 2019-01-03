package br.com.apoio.service;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apoio.model.ImplantacaoPendente;
import br.com.apoio.model.ImplantacoesDoMes;
import br.com.apoio.repository.RepositorioImplantacao;
import br.com.apoio.utils.UtilData;

@Service
public class ServicoImplantacao {

	@Autowired
	private RepositorioImplantacao repositorioImplantacao;

	public ImplantacoesDoMes getImplantacoesDoMes() throws SQLException {

		ImplantacoesDoMes implantacoesDoMes = repositorioImplantacao.getImplantacoesDoMes(
				UtilData.getPrimeiroDiaDaDataCompletaDoMesAtual(), UtilData.getUltimoDiaDaDataCompletaDoMesAtual());

		implantacoesDoMes.setQtdCancelado(repositorioImplantacao.getImplantacoesCanceladasDoMes(
				UtilData.getPrimeiroDiaDaDataCompletaDoMesAtual(), UtilData.getUltimoDiaDaDataCompletaDoMesAtual()));

		return implantacoesDoMes;
	}

	public Collection<ImplantacaoPendente> getImplantacoesPendentes() throws SQLException {
		return repositorioImplantacao.getImplantacoesPendentes();
	}
}
