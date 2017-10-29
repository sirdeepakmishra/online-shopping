package net.deepak.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.deepak.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshoppingdb";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="root";
	
	
	//datasource bean avalibale
	@Bean
	public DataSource getDataSource(){
		
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName(DATABASE_DRIVER);
		bds.setUrl(DATABASE_URL);
		bds.setUsername(DATABASE_USERNAME);
		bds.setPassword(DATABASE_PASSWORD);
		
		return bds;
		
	}
	
	//sessionFACTORY bean avalibale
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		
		
	builder.addProperties(getHibernateProperties());
	builder.scanPackages("net.deepak.shoppingbackend.dto");	
		
		return builder.buildSessionFactory();
		
		
		
	}

	//all the hibernate properties will be return in this method
	private Properties getHibernateProperties() {
		Properties properties =new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	
	//hibernate  transaction manager  bean
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}

}
