package br.com.apoio.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apoio.model.ImplantacoesDoMes;
import br.com.apoio.service.ServicoImplantacao;

@RestController
@RequestMapping("/implantacao")
public class ImplantacaoController {
	
	  @Autowired
	  private ServicoImplantacao servicoImplantacao;

	@GetMapping
	@RequestMapping(value = "/mensal")
	public ImplantacoesDoMes listar() throws SQLException {
		return servicoImplantacao.getImplantacoesDoMes();
	}
}
