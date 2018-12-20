package br.com.apoio.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apoio.model.ImplantacoesDoMes;
import br.com.apoio.repository.RepositorioImplantacao;
import br.com.apoio.utils.UtilData;

@Service
public class ServicoImplantacao {
	
	@Autowired
	private RepositorioImplantacao repositorioImplantacao;

	public ImplantacoesDoMes getImplantacoesDoMes() throws SQLException {

		
		return repositorioImplantacao.getImplantacoesDoMes(UtilData.getPrimeiroDiaDaDataCompletaDoMesAtual(),
				UtilData.getUltimoDiaDaDataCompletaDoMesAtual());
	}
}
