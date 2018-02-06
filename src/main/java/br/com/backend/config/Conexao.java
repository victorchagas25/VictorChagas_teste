package br.com.backend.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static String status = "Não conectou...";

	public Conexao() {

	}

	public Connection getConexaoPostgress() {

		Connection connection = null;
		try {
			String driverName = "org.postgresql.Driver";
			Class.forName(driverName);
			String serverName = "localhost:5432";
			String mydatabase = "taxidb"; 
			String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
			String username = "postgres"; 
			String password = "251196";
			
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) { 
			// Driver não encontrado
			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			// Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	// Método que retorna o status da sua conexão//
	public static String statusConection() {

		return status;

	}
	
	// Método que fechar conexão//
	public void close(Connection connection) throws SQLException {

		connection.close();

	}

	

}
