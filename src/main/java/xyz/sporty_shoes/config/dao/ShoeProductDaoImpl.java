package xyz.sporty_shoes.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xyz.sporty_shoes.config.entity.ShoeProduct;

@Repository
public class ShoeProductDaoImpl implements ShoeProductDao {

	private Session session;
	
	@Autowired
	public ShoeProductDaoImpl(Session session) {
		this.session = session;
	}
	
	public ShoeProductDaoImpl() {
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	@Transactional
	public List<ShoeProduct> listShoeProducts() {
		return session.createQuery("from ShoeProduct").getResultList();
	}

	@Override
	@Transactional
	public ShoeProduct getShoeProductById(int id) {
		ShoeProduct shoeProduct = session.get(ShoeProduct.class, id);
		return shoeProduct;
	}

	@Override
	@Transactional
	public void addShoeProduct(ShoeProduct shoeProduct) {
		session.save(shoeProduct);
		System.out.println("Shoe product added.");
	}

	@Override
	@Transactional
	public void updateShoeProduct(ShoeProduct shoeProduct, int id) {
		ShoeProduct sp = getShoeProductById(id);
		sp = shoeProduct;
		session.saveOrUpdate(sp);
		System.out.println("Shoe product updated.");
	}

	@Override
	@Transactional
	public void deleteShoeProduct(int id) {
		ShoeProduct shoeProduct = session.get(ShoeProduct.class, id);
		session.delete(shoeProduct);
		System.out.println("Shoe product deleted.");
	}

}
