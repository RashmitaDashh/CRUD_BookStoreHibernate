package com.hibernateCrud.CRUD_hibernate.controllers;

import java.io.IOException;
import java.util.List;

import com.hibernateCrud.CRUD_hibernate.configFactory.HibernateFactoryConfig;
import com.hibernateCrud.CRUD_hibernate.entities.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/toAllBooks", "/toCreateBook", "/toUpdateBook", "/toDeleteBook" })
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case "/toAllBooks":
			listBooks(req, res);
			break;

		case "/toCreateBook":
			forwardToCreateBook(req, res);
			break;

		case "/toUpdateBook":
			forwardToUpdateBook(req, res);
			break;

		case "/toDeleteBook":
			forwardToDeleteBook(req, res);
			break;

		default:
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void listBooks(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Book> bookList = HibernateFactoryConfig.getbookDAO().getBookList();
		req.setAttribute("books", bookList);
		req.getRequestDispatcher("/WEB-INF/views/listBooks.jsp").forward(req, res);
	}

	private void forwardToCreateBook(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/createBook.jsp").forward(req, res);
	}

	private void forwardToUpdateBook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String bookIdParam = req.getParameter("id");
		System.out.println(bookIdParam);
        if (bookIdParam != null) {
            int bookId = Integer.parseInt(bookIdParam); // Convert to integer
            Book book = HibernateFactoryConfig.getbookDAO().getBookById(bookId); // Fetch user by ID
            System.out.println(book);
    		req.setAttribute("book", book); // Set user in request scope
        	req.getRequestDispatcher("/WEB-INF/views/updateBook.jsp").forward(req, res);
        }
    }

	private void forwardToDeleteBook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/deleteBook").forward(req, res);
	}
}

/*
 * @WebServlet("/allBooks") public class ListBooksController extends
 * HttpServlet{
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * //private HibernateFactoryConfig hfc;
 * 
 * public void doGet(HttpServletRequest req, HttpServletResponse res) throws
 * ServletException, IOException {
 * 
 * List<Book> BookList = HibernateFactoryConfig.getUserDAO().getBookList();
 * req.setAttribute("books", bookList);
 * req.getRequestDispatcher("/WEB-INF/views/listBooks.jsp").forward(req, res); }
 * 
 * }
 */