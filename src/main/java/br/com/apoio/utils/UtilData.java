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

	public static String getConverteDataAoContrario(String data) {
		if (data != null || !data.equals("")) {
			String dia = data.substring(8, 10);
			String mes = data.substring(5, 7);
			String ano = data.substring(0, 4);
			return dia + "/" + mes + "/" + ano;
		}
		return null;

	}
}
