package br.com.apoio.conexao.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class ConexaoSQLite {

	private static Connection conexao;

	private String url;

	public ConexaoSQLite() {
		url = "jdbc:sqlite:C:\\Users\\brunofelipe.SYNCODE\\Desktop\\db\\dbApoio.db";
	}

	private Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection(url);
			return conexao;
			
		} catch (ClassNotFoundException ex) {
			System.out.println("O driver não foi encontrado");
			return null;
			
		} catch (SQLException ex) {
			System.out.println("Problemas com a conexão\n" + ex.getMessage());
			return null;
		}
	}

	public int executeUpdateInsert(String query) {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(query);
			con.close();
			return res;
		} catch (SQLException ex) {
			System.out.println("Problemas com a conexão\n" + ex.getMessage());
			return 0;
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			//con.close();
			return rs;
		} catch (SQLException ex) {
			System.out.println("Problemas com a conexão\n" + ex.getMessage());
			return null;
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}