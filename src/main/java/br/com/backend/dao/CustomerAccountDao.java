package br.com.backend.dao;

import java.util.List;

import br.com.backend.model.CustomerAccount;

public interface CustomerAccountDao {
	
	void inserirDados(CustomerAccount customerAccount);
	
	List<CustomerAccount> consutarDadosByRegra();
	
	List<CustomerAccount> consutarTodos();

}
