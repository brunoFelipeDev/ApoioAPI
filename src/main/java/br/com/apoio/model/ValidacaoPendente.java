package br.com.apoio.model;

public class ValidacaoPendente {

	private Cliente cliente;
	private String sistemaDeConversao;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSistemaDeConversao() {
		if (sistemaDeConversao == null || sistemaDeConversao.equals(""))
			return "Sem conversão";

		return sistemaDeConversao;
	}

	public void setSistemaDeConversao(String sistemaDeConversao) {
		this.sistemaDeConversao = sistemaDeConversao;
	}
}
