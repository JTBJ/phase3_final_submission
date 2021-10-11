package xyz.sporty_shoes.config.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.sporty_shoes.config.entity.Role;
import xyz.sporty_shoes.config.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
//	@Autowired
	private SessionFactory sessionFactory;
	
	{
		sessionFactory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Role.class)
				.buildSessionFactory();
	}

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

}
