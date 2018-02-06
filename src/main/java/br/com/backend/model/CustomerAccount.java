package br.com.backend.model;

public class CustomerAccount {

	private Integer idCustomer;
	private String cpf_cnpj;
	private String nm_customer;
	private Boolean is_active;
	private Double vl_total;

	public CustomerAccount() {

	}

	public CustomerAccount(Integer idCustomer, String cpf_cnpj, String nm_customer, Boolean is_active,
			Double vl_total) {
		super();
		this.idCustomer = idCustomer;
		this.cpf_cnpj = cpf_cnpj;
		this.nm_customer = nm_customer;
		this.is_active = is_active;
		this.vl_total = vl_total;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNm_customer() {
		return nm_customer;
	}

	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public double getVl_total() {
		return vl_total;
	}

	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}

}
