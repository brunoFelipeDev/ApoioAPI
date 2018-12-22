package br.com.apoio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.apoio.conexao.sqlite.ConexaoSQLite;

@Repository
public class Repositorio {

	@Autowired
	public ConexaoSQLite conexaoSQLite;
	
}
