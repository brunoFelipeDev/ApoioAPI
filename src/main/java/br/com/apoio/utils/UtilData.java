package br.com.apoio.utils;

import java.text.DateFormat;
import java.util.Date;

public class UtilData {

	public static String getMesAtual() {

		Date d = new Date();
		String mes = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

		return mes.substring(3, 5);
	}

	public static String getAnoAtual() {

		Date d = new Date();
		String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

		return data.substring(6, 10);
	}

	public static String getPrimeiroDiaDaDataCompletaDoMesAtual() {
		return getAnoAtual() + "-" + getMesAtual() + "-" + "01";
	}

	public static String getUltimoDiaDaDataCompletaDoMesAtual() {
		return getAnoAtual() + "-" + getMesAtual() + "-" + "31";
	}
}
