package br.com.apoio.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apoio.model.Treinamento;
import br.com.apoio.model.TreinamentosDoMes;
import br.com.apoio.service.ServicoTreinamento;

@RestController
@RequestMapping("/treinamento")
@CrossOrigin
public class TreinamentoController {

	@Autowired
	private ServicoTreinamento servicoTreinamento;

	@GetMapping
	@RequestMapping(value = "/mensal")
	public TreinamentosDoMes getInformacoesDosTreinamentosDoMes() throws SQLException {
		return servicoTreinamento.getTreinamentosDoMes();
	}
	
	@GetMapping
	@RequestMapping(value = "/ultimosvinte")
	public Collection<Treinamento> getUltimosVinteTreinamentos() throws SQLException {
		return servicoTreinamento.getUltimosVinteTreinamentos();
	}
}
