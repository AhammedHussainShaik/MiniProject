package com.project.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.models.Employee;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class ApplicationDBConfig {
	@Autowired
	Environment environment;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.user"));
		dataSource.setPassword(environment.getProperty("db.pwd"));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();

		factoryBean.setDataSource(dataSource());
		factoryBean.setAnnotatedClasses(Employee.class);
		factoryBean.setHibernateProperties(getProperties());

		return factoryBean;
	}

	@Bean
	public HibernateTemplate template() {
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactoryBean().getObject());
		return hibernateTemplate;
	}
// for Hibernate Properties
	public Properties getProperties() {
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", environment.getProperty("orm.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("orm.showsql"));
		properties.put("hibernate.format_sql", environment.getProperty("orm.fmtsql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("orm.ddlauto"));
		
		return properties;
	}

}
