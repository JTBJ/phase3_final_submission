package xyz.sporty_shoes.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.sporty_shoes.config.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

//	@Autowired
	private Session session;
	
	@Autowired
	public CustomerDaoImpl(Session session) {
		this.session = session;
	}
	
	public CustomerDaoImpl() {
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return session.createQuery("from Customer").getResultList();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
//		session.save(customer);
		if(customer == null) {
			System.out.println("customer is null");
		}
		if(session == null) {
			System.out.println("session is null");
		}
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer, int id) {
		Customer c = getCustomerById(id);
		c = customer;
		session.saveOrUpdate(c);
		System.out.println("Customer updated.");
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
		session.createQuery("delete from Customer c where c.id='" + id + "'").executeUpdate();
		System.out.println("Customer deleted.");
	}

	@Override
	@Transactional
	public void initCustomerTable(Customer customer) {
		Session session;
	}
}
