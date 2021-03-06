package br.com.apoio.model;

import br.com.apoio.utils.UtilData;

public class Treinamento {

	private int id;
	private Cliente cliente;
	private String funcaoTreinada;
	private String tecnicoResponsavel;
	private int duracao;
	private String data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return UtilData.getConverteDataAoContrario(data);

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFuncaoTreinada() {
		return funcaoTreinada;
	}

	public void setFuncaoTreinada(String funcaoTreinada) {
		this.funcaoTreinada = funcaoTreinada;
	}

	public String getTecnicoResponsavel() {
		return tecnicoResponsavel;
	}

	public void setTecnicoResponsavel(String tecnicoResponsavel) {
		this.tecnicoResponsavel = tecnicoResponsavel;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getHoras() {
		int totalMinutes = getDuracao();
		int hours = totalMinutes / 60;
		int minutes = totalMinutes % 60;

		String horas = hours + ":" + minutes;
		if (horas.length() == 3)
			horas = horas + "0";
		return horas;
	}

}
