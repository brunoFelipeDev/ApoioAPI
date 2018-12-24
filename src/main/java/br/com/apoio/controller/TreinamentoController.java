package br.com.apoio.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apoio.model.Treinamento;
import br.com.apoio.model.TreinamentosDoMes;
import br.com.apoio.service.ServicoTreinamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "treinamento", description = "Controlador de treinamento")
@RequestMapping("/treinamento")
@CrossOrigin
public class TreinamentoController {

	@Autowired
	private ServicoTreinamento servicoTreinamento;

	@GetMapping(value = "/mensal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Retonar os treinamentos do mês")
	public TreinamentosDoMes getInformacoesDosTreinamentosDoMes() throws SQLException {
		return servicoTreinamento.getTreinamentosDoMes();
	}
	
	@GetMapping(value = "/ultimosvinte", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Retonar os ultimos vinte treinamentos do mês")
	public Collection<Treinamento> getUltimosVinteTreinamentos() throws SQLException {
		return servicoTreinamento.getUltimosVinteTreinamentos();
	}
}
