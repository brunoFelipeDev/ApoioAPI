package br.com.apoio.model;

public class TreinamentosDoMes {

	private int qtdTreinamentosRealizadosParaClientesDoSit;
	private int qtdTreinamentosRealizadosParaClientesDoSup;

	public int getQtdTreinamentosRealizadosParaClientesDoSit() {
		return qtdTreinamentosRealizadosParaClientesDoSit;
	}

	public void setQtdTreinamentosRealizadosParaClientesDoSit(int qtdTreinamentosRealizadosParaClientesDoSit) {
		this.qtdTreinamentosRealizadosParaClientesDoSit = qtdTreinamentosRealizadosParaClientesDoSit;
	}

	public int getQtdTreinamentosRealizadosParaClientesDoSup() {
		return qtdTreinamentosRealizadosParaClientesDoSup;
	}

	public void setQtdTreinamentosRealizadosParaClientesDoSup(int qtdTreinamentosRealizadosParaClientesDoSup) {
		this.qtdTreinamentosRealizadosParaClientesDoSup = qtdTreinamentosRealizadosParaClientesDoSup;
	}

	public int getTotalDeTreinamentosNoMesAtual() {
		return getQtdTreinamentosRealizadosParaClientesDoSit() + getQtdTreinamentosRealizadosParaClientesDoSup();
	}

}
