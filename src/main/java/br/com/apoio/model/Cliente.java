package br.com.apoio.model;

public class Cliente {

	private String numeroDeSerie;
	private String razaoSocial;
	private String sistemaDeConversao;

	public String getSistemaDeConversao() {
		return sistemaDeConversao;
	}

	public void setSistemaDeConversao(String sistemaDeConversao) {
		this.sistemaDeConversao = sistemaDeConversao;
	}

	public Cliente(String numeroDeSerie, String razaoSocial) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.razaoSocial = razaoSocial;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
