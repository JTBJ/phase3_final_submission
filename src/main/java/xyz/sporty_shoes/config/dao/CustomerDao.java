package xyz.sporty_shoes.config.dao;

import java.util.List;

import xyz.sporty_shoes.config.entity.Customer;

public interface CustomerDao {

	public List<Customer> listCustomers();
	
	public Customer getCustomerById(int id);
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer, int id);
	
	public void deleteCustomerById(int id);
	
	public void initCustomerTable(Customer customer);
	
}
