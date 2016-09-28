package com.niit.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.dao.BlogDAOImpl;
import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.dao.EventDAOImpl;
import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.dao.JobDAOImpl;
import com.niit.collaboration.dao.RoleDAO;
import com.niit.collaboration.dao.RoleDAOImpl;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.dao.UserDAOImpl;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Event;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.Role;
import com.niit.collaboration.model.Users;


@Configuration
@ComponentScan("com.niit.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("collaboration");
		dataSource.setPassword("password");
		
		return dataSource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Users.class);
    	sessionBuilder.addAnnotatedClass(Role.class);
    	sessionBuilder.addAnnotatedClass(Blog.class);
    	sessionBuilder.addAnnotatedClass(Job.class);
    	sessionBuilder.addAnnotatedClass(Event.class);
    	return sessionBuilder.buildSessionFactory();
    }

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
	
	@Autowired
    @Bean(name = "userDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory) 
	{
    	return new UserDAOImpl(sessionFactory);
    }

	@Autowired
	@Bean(name="roleDAO")
	public RoleDAO getRoleDao(SessionFactory sessionFactory)
	{
		return new RoleDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name="blogDAO")
	public BlogDAO getBlogDao(SessionFactory sessionFactory)
	{
		return new BlogDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="jobDAO")
	public JobDAO getJobDao(SessionFactory sessionFactory)
	{
		return new JobDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="eventDAO")
	public EventDAO getEventDao(SessionFactory sessionFactory)
	{
		return new EventDAOImpl(sessionFactory);
	}
	
}
