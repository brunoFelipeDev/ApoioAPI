package br.com.apoio.model;

import java.math.BigDecimal;

public class ImplantacoesDoMes {

	private int qtdCancelado;
	private int qtdComConversao;
	private int qtdSemConversao;

	public int getQtdCancelado() {
		return qtdCancelado;
	}

	public void setQtdCancelado(int qtdCancelado) {
		this.qtdCancelado = qtdCancelado;
	}

	public int getQtdComConversao() {
		return qtdComConversao;
	}

	public void setQtdComConversao(int comConversao) {
		this.qtdComConversao = comConversao;
	}

	public int getQtdSemConversao() {
		return qtdSemConversao;
	}

	public void setQtdSemConversao(int semConversao) {
		this.qtdSemConversao = semConversao;
	}

	public int getImplantacoesTotal() {
		return getQtdComConversao() + getQtdSemConversao();
	}

	public BigDecimal getValorParaReceberNoMes() {
		return new BigDecimal(getImplantacoesTotal()).multiply(new BigDecimal(50));
	}
}
