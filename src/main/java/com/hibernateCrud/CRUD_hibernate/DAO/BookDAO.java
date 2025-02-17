package com.hibernateCrud.CRUD_hibernate.DAO;

import java.util.List;

import com.hibernateCrud.CRUD_hibernate.entities.Book;

public interface BookDAO {
	public List<Book> getBookList();
	public Book getBookById(int id);
	public void insertBookDetails(Book book);
	public void updateBookDetails(Book book, int id);
	public Book deleteBookDetails(int id);
}
