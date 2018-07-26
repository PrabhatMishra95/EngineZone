package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.dao.*;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{
	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/EZone");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Data Source Created");
		return dataSource;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.show_sql","true");
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addProperties(hibernateProp);
		factoryBuilder.scanPackages("com.niit");
		
		
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	/*
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("Category DAO Implementation");
		return new CategoryDAOImpl();
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("Product DAO Implementation");
		return new ProductDAOImpl();
	}
	
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDAO()
	{
		System.out.println("Cart DAO Implementation");
		return new CartDAOImpl();
	}
	
	@Autowired
	@Bean(name="orderDAO")
	public OrderDAO getOrderDAO()
	{
		System.out.println("Order DAO Implementation");
		return new OrderDAOImpl();
	}
*/	
	@Autowired
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}
