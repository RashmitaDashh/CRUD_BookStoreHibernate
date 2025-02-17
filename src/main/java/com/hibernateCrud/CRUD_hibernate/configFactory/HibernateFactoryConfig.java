package com.hibernateCrud.CRUD_hibernate.configFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernateCrud.CRUD_hibernate.DAO.BookDAO;
import com.hibernateCrud.CRUD_hibernate.DAO.BookDAOImpl;

public class HibernateFactoryConfig {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("/com/hibernateCrud/CRUD_hibernate/config/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
	
	public static BookDAO getbookDAO() {
		BookDAO bookDAOImpl = new BookDAOImpl();
		return bookDAOImpl;
	}
}
