package com.jsp.productservice.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.productservice.entity.ProductEntity;

public class SessionFactoryUtil {

	public static SessionFactory sessionFactory;

	public static SessionFactory getFactory() {

		if (sessionFactory == null) {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(ProductEntity.class);
			cfg.setProperties(getProperties());
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;

		}
		return sessionFactory;

	}

	public static Properties getProperties() {

		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/products");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");

		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

		return prop;

	}

}
