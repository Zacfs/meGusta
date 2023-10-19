package meGusta;
import java.security.*;
import java.math.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	protected Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	//Método para criptografia
	static String toMD5(String s) {
		String resp ="";
		try {
		MessageDigest m=MessageDigest.getInstance("MD5");
	       m.update(s.getBytes(),0,s.length());
	       resp = (new BigInteger(1,m.digest()).toString(16));
		}catch(NoSuchAlgorithmException e) {
			System.out.println("erro");
		}
		return resp;
	}
	//Conexão com banco de dados
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String serverName = "localhost";
		String mydatabase = "meGusta";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}
		return status;
	}

	public boolean close() {
		boolean status = false;

		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

}
