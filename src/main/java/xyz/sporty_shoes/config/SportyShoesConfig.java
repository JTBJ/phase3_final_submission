package xyz.sporty_shoes.config;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import xyz.sporty_shoes.config.dao.CustomerDao;
import xyz.sporty_shoes.config.dao.CustomerDaoImpl;
import xyz.sporty_shoes.config.dao.ShoeCategoryDao;
import xyz.sporty_shoes.config.dao.ShoeCategoryDaoImpl;
import xyz.sporty_shoes.config.dao.ShoeProductDao;
import xyz.sporty_shoes.config.dao.ShoeProductDaoImpl;
import xyz.sporty_shoes.config.entity.Customer;
import xyz.sporty_shoes.config.entity.PurchaseReports;
import xyz.sporty_shoes.config.entity.ShoeCategory;
import xyz.sporty_shoes.config.entity.ShoeProduct;
import xyz.sporty_shoes.config.lifecycle.InstantiateDatabase;

@Configuration
@EnableWebMvc
@PropertySource("classpath:sportyshoes.properties")
@ComponentScan(basePackages = "xyz.sporty_shoes.config")
public class SportyShoesConfig {
	
	Logger logger = Logger.getLogger(getClass().getName());

	// helper object to hold the data in the properties file
	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// define bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		//logger info to console
		logger.info("logger >>> " + env.getProperty("jdbc.driver"));
		
		// set jdbc connection properties
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool properties
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);

		int intPropVal = Integer.parseInt(propVal);

		return intPropVal;
	}
	
//	@Bean
//	public CustomerDao getCustomerDaoImpl() {
//		return new CustomerDaoImpl();
//	}
//	
//	@Bean
//	public ShoeCategoryDao getShoeCategoryDaoImpl() {
//		return new ShoeCategoryDaoImpl();
//	}
//	
//	@Bean
//	public ShoeProductDao getShoeProductDaoImpl() {
//		return new ShoeProductDaoImpl();
//	}

	@Bean
    public Session getSession() throws HibernateException {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(ShoeCategory.class)
                .addAnnotatedClass(ShoeProduct.class)
                .addAnnotatedClass(PurchaseReports.class)
                .buildSessionFactory();

        return sessionFactory.openSession();
    }
	
	@PostConstruct
	private void callDatabaseInit() {
		new InstantiateDatabase().initializeDatabase();
	}
	
}
