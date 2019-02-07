package br.com.apoio.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ImplantacoesDoMes {

	private int qtdCancelado;
	private int qtdComConversao;
	private int qtdSemConversao;
	private TempoGasto tempoGasto;
	private ArrayList<Cliente> clientesImplantadosSemCancelamento;
	private ArrayList<Cliente> clientesQueCancelaramNoMes;

		public ArrayList<Cliente> getClientesQueCancelaramNoMes() {
		return clientesQueCancelaramNoMes;
	}

	public void setClientesQueCancelaramNoMes(ArrayList<Cliente> clientesQueCancelaramNoMes) {
		this.clientesQueCancelaramNoMes = clientesQueCancelaramNoMes;
	}

	public ArrayList<Cliente> getClientesImplantadosSemCancelamento() {
		return clientesImplantadosSemCancelamento;
	}

	public void setClientesImplantadosSemCancelamento(ArrayList<Cliente> clientes) {
		this.clientesImplantadosSemCancelamento = clientes;
	}

	public TempoGasto getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(TempoGasto tempoGasto) {
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
