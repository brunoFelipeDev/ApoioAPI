package br.com.apoio.model;

import br.com.apoio.utils.UtilData;

public class Cliente {

	private String numeroDeSerie;
	private String razaoSocial;
	private String sistemaDeConversao;
	private String dataImplantado;

	public Cliente(String numeroDeSerie, String razaoSocial) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.razaoSocial = razaoSocial;
	}

	public Cliente(String numeroDeSerie, String razaoSocial, String sistemaDeConversao, String dataImplantado) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.razaoSocial = razaoSocial;
		this.sistemaDeConversao = sistemaDeConversao;
		this.dataImplantado = dataImplantado;
	}

	public String getDataImplantado() {
		if (dataImplantado != null)
			return UtilData.getConverteDataAoContrario(dataImplantado);
		return null;
	}

	public void setDataImplantado(String dataImplantado) {
		this.dataImplantado = dataImplantado;
	}

	public String getSistemaDeConversao() {
		return sistemaDeConversao;
	}

	public void setSistemaDeConversao(String sistemaDeConversao) {
		this.sistemaDeConversao = sistemaDeConversao;
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
