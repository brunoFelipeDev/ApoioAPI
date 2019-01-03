package br.com.apoio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apoio.model.ImplantacaoPendente;
import br.com.apoio.model.ImplantacoesDoMes;
import br.com.apoio.service.ServicoImplantacao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "implantacao", description = "Controlador de implantação")
@RequestMapping("/implantacao")
@CrossOrigin
public class ImplantacaoController {

	@Autowired
	private ServicoImplantacao servicoImplantacao;

	@ApiOperation(value = "Retonar as implantações do mês")
	@GetMapping(value = "/mensal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ImplantacoesDoMes listar() throws SQLException {
		return servicoImplantacao.getImplantacoesDoMes();
	}

	@GetMapping("/pendente")
	public Collection<ImplantacaoPendente> getImplantacoesPendentes() throws SQLException {
		return servicoImplantacao.getImplantacoesPendentes();
	}
	
	@GetMapping("/teste")
	public Collection<int[]> getTeste() {
		
		Collection<int[]> numeros = new ArrayList<>();
		numeros.add(new int[] {1,2,3,2,2});
		numeros.add(new int[] {1,1,1,1,1});
		return numeros;
	}
}
