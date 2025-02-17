package com.hibernateCrud.CRUD_hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernateCrud.CRUD_hibernate.configFactory.HibernateFactoryConfig;
import com.hibernateCrud.CRUD_hibernate.entities.Book;

public class BookDAOImpl implements BookDAO{

	// GET LIST OF ALL BOOKS
		@Override
		public List<Book> getBookList() {
			List<Book> books= null;
			try(Session session = HibernateFactoryConfig.getSessionFactory().openSession()){
				books = session.createQuery("from Book", Book.class).list();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return books;
		}

		// GET A USER'S DETAILS BY THEIR ID
		@Override
		public Book getBookById(int id) {
			Book book = null;
			try(Session session = HibernateFactoryConfig.getSessionFactory().openSession()) {
				book = session.get(Book.class, id);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return book;
		}
		
		//INSERT A BOOK
		@Override
		public void insertBookDetails(Book book) {
			Transaction transaction = null;
			System.out.println(book);
			try(Session session = HibernateFactoryConfig.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.save(book);
				transaction.commit();
			} catch(Exception e) {
				//transaction.rollback();
				e.printStackTrace();
			}
		}

		//UPDATE A BOOK
		@Override
		public void updateBookDetails(Book book, int id) {
			Transaction transaction = null;
			String name = book.getName();
			String author = book.getAuthor();
			String language = book.getLanguage();
			String publisher = book.getPublisher();
			String seller = book.getSeller();
			try(Session session = HibernateFactoryConfig.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				Book bk = session.get(Book.class, id);
				bk.setName(name);
				bk.setAuthor(author);
				bk.setLanguage(language);
				bk.setPublisher(publisher);
				bk.setSeller(seller);
				session.update(bk);
				transaction.commit();
				
			} catch(Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
		
		//DELETE A BOOK
		@Override
		public Book deleteBookDetails(int id) {
			Transaction transaction = null;
			Book book = null;
			try(Session session = HibernateFactoryConfig.getSessionFactory().openSession()){
				transaction = session.beginTransaction();
				book = session.get(Book.class, id); 
				session.delete(book);
				transaction.commit();
			} catch(Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
			return book;
		}

}
