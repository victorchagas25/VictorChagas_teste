package br.com.backend;

import java.util.List;
import java.util.Random;

import br.com.backend.dao.CustomerAccountDao;
import br.com.backend.dao.CustomerAccountDaoImpl;
import br.com.backend.model.CustomerAccount;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		
		if (args[0].equalsIgnoreCase("Consultar")) {
			app.consultar();
		}else if(args[0].equalsIgnoreCase("Inserir")){
			app.addVarios(90);
		}
		
	}

	private void inserirDados(CustomerAccount customerAccount) {
		CustomerAccountDao dao = new CustomerAccountDaoImpl();
		dao.inserirDados(customerAccount);

	}

	private void addVarios(Integer numeroCustomers) {
		App app = new App();
		Random gerador = new Random();
		for (int i = 0; i < numeroCustomers; i++) {
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setCpf_cnpj("38682388839");
			customerAccount.setIs_active(true);
			customerAccount.setNm_customer("Fernando"+i);
			customerAccount.setVl_total(gerador.nextInt(3000));
			
			System.out.println("Contador " + i);
			app.inserirDados(customerAccount);
		}
		System.out.println("Finalizou");
	}
	
	private void consultar(){
		CustomerAccountDao dao = new CustomerAccountDaoImpl();
		List<CustomerAccount> listaCustomer = dao.consutarDadosByRegra();
		System.out.println(listaCustomer);
		mostrarMedia(listaCustomer);
	}
	
	private void mostrarMedia(List<CustomerAccount> listaCustomer){
		int count = 1;
		Double valorTotal = 0D;
		
		for(int i=0; i < listaCustomer.size(); i++){
			valorTotal = valorTotal + listaCustomer.get(i).getVl_total();
			System.out.println("Cliente " + listaCustomer.get(i).getNm_customer());
			count ++;
		}
		
		System.out.println("Valor Total = " + valorTotal);
		System.out.println("Média =" + valorTotal/count);
		
	}
	
	
}
