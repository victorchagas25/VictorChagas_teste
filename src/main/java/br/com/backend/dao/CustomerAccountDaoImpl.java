package br.com.backend.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.backend.config.Conexao;
import br.com.backend.model.CustomerAccount;

public class CustomerAccountDaoImpl implements CustomerAccountDao {

	/**
	 * Metodo resposavel por inserir Customers
	 * 
	 */
	public void inserirDados(CustomerAccount customerAccount) {

		try {
			Conexao conexao = new Conexao();
			String sql = "insert into tb_customer_account (cpf_cnpj , nm_customer,is_active,vl_total) values(?, ?, ?, ?)";
			PreparedStatement statement = conexao.getConexaoPostgress().prepareStatement(sql);
			statement.setString(1, customerAccount.getCpf_cnpj());
			statement.setString(2, customerAccount.getNm_customer());
			statement.setBoolean(3, customerAccount.getIs_active());
			statement.setDouble(4, customerAccount.getVl_total());
			statement.execute();
			statement.close();
			conexao.close(conexao.getConexaoPostgress());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CustomerAccount> consutarDadosByRegra() {

		try {
			Conexao conexao = new Conexao();
			String sql = "select * from tb_customer_account where id_costumer between 1500  and 2700 and vl_total > 560 order by vl_total DESC ";
			PreparedStatement statement1 = conexao.getConexaoPostgress().prepareStatement(sql);
			ResultSet resultSet = statement1.executeQuery();

			// Cria lista customer
			List<CustomerAccount> listaCustomer = new ArrayList<CustomerAccount>();

			while (resultSet.next()) {

				CustomerAccount customerAccount = new CustomerAccount(resultSet.getInt("id_costumer"),
						resultSet.getString("cpf_cnpj"), resultSet.getString("nm_customer"),
						resultSet.getBoolean("is_active"), resultSet.getDouble("vl_total"));

				listaCustomer.add(customerAccount);
			}
			conexao.close(conexao.getConexaoPostgress());
			return listaCustomer;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CustomerAccount> consutarTodos() {
		try {
			Conexao conexao = new Conexao();
			String sql = "select * from tb_customer_account";
			PreparedStatement statement1 = conexao.getConexaoPostgress().prepareStatement(sql);
			ResultSet resultSet = statement1.executeQuery();

			// Cria lista customer
			List<CustomerAccount> listaCustomer = new ArrayList<CustomerAccount>();

			while (resultSet.next()) {

				CustomerAccount customerAccount = new CustomerAccount(resultSet.getInt("id_costumer"),
						resultSet.getString("cpf_cnpj"), resultSet.getString("nm_customer"),
						resultSet.getBoolean("is_active"), resultSet.getDouble("vl_total"));

				listaCustomer.add(customerAccount);
			}
			conexao.close(conexao.getConexaoPostgress());
			return listaCustomer;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
