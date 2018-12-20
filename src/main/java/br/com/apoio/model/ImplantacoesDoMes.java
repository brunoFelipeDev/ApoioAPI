package br.com.apoio.model;

public class ImplantacoesDoMes {

	private int comConversao;
	private int semConversao;

	public int getImplantacoesTotal() {
		return getComConversao() + getSemConversao();
	}

	public int getComConversao() {
		return comConversao;
	}

	public void setComConversao(int comConversao) {
		this.comConversao = comConversao;
	}

	public int getSemConversao() {
		return semConversao;
	}

	public void setSemConversao(int semConversao) {
		this.semConversao = semConversao;
	}

}
