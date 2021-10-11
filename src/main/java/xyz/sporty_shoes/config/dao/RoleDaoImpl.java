package xyz.sporty_shoes.config.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import xyz.sporty_shoes.config.entity.Role;
import xyz.sporty_shoes.config.entity.User;


@Repository
public class RoleDaoImpl implements RoleDao {

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
	public Role findRoleByName(String theRoleName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}
}
