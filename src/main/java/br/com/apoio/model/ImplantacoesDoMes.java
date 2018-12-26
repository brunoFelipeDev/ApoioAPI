package br.com.apoio.model;

import java.math.BigDecimal;

public class ImplantacoesDoMes {

	private int qtdCancelado;
	private int qtdComConversao;
	private int qtdSemConversao;
	private TempoGasto tempoGasto;

	public TempoGasto getTempoGastoNoProcesso() {
		return tempoGasto;
	}

	public void setTempoGastoNoProcesso(TempoGasto tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

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

	public int getQuantidadeDeImplantacoesTotal() {
		return getQtdComConversao() + getQtdSemConversao();
	}

	public BigDecimal getValorParaReceberNoMes() {
		return new BigDecimal(getQuantidadeDeImplantacoesTotal()).multiply(new BigDecimal(50));
	}

}
