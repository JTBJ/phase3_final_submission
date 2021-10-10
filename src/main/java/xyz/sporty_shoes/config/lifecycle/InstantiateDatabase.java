package xyz.sporty_shoes.config.lifecycle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.sporty_shoes.config.dao.CustomerDao;
import xyz.sporty_shoes.config.dao.CustomerDaoImpl;
import xyz.sporty_shoes.config.dao.ShoeCategoryDao;
import xyz.sporty_shoes.config.dao.ShoeCategoryDaoImpl;
import xyz.sporty_shoes.config.entity.Customer;
import xyz.sporty_shoes.config.entity.PurchaseReports;
import xyz.sporty_shoes.config.entity.ShoeCategory;
import xyz.sporty_shoes.config.entity.ShoeProduct;

@Component
public class InstantiateDatabase {
	
	public InstantiateDatabase() {
	}

	public void initializeDatabase() {
				
		Customer c = new Customer("Ashely", "test123", "firstName", "Palmer", "ashely@palmer.com");
		Customer c1 = new Customer("David", "test123", "David", "Westing", "david@westing.com");
		Customer c2 = new Customer("Paul", "test123", "Paul", "Gordon", "paul@gordon.com");
		Customer c3 = new Customer("Ruth", "test123", "Ruth", "Patrick", "ruth@patrick.com");
		Customer c4 = new Customer("Megan", "test123", "Megan", "Hunter", "megan@hunter.com");
		
		ShoeProduct sp = new ShoeProduct("Jordans");
		ShoeProduct sp1 = new ShoeProduct("Stacey Adams");
		ShoeProduct sp2 = new ShoeProduct("Tysons");
		ShoeProduct sp3 = new ShoeProduct("Nautica");
		ShoeProduct sp4 = new ShoeProduct("Gucci");
		
		ShoeCategory sc = new ShoeCategory("Dress Shoes");
		ShoeCategory sc1 = new ShoeCategory("Sneakers");
		ShoeCategory sc2 = new ShoeCategory("Luxury");
		
		sp.setProductCategory(sc1);
		sp1.setProductCategory(sc2);
		sp2.setProductCategory(sc1);
		sp3.setProductCategory(sc);
		sp4.setProductCategory(sc2);
		
//		List<ShoeProduct> list = new ArrayList<>();
		
//		list.add(sp);

//		c.setShoeProduct(list);
		
		System.out.println("Inside init");
		
		SessionFactory sessionFactory =
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(ShoeProduct.class)
				.addAnnotatedClass(ShoeCategory.class)
				.addAnnotatedClass(PurchaseReports.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(c);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		
		session.save(sp);
		session.save(sp1);
		session.save(sp2);
		session.save(sp3);
		session.save(sp4);
		
		session.save(sc);
		session.save(sc1);
		session.save(sc2);
		
		session.getTransaction().commit();
		session.close();
	}

}
