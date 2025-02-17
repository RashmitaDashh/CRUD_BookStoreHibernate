package com.hibernateCrud.CRUD_hibernate.controllers;

import java.io.IOException;

import com.hibernateCrud.CRUD_hibernate.configFactory.HibernateFactoryConfig;
import com.hibernateCrud.CRUD_hibernate.entities.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveBook")
public class CreateBookController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        // Fetch form data
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String language = req.getParameter("language");
        String publisher = req.getParameter("publisher");
        String seller = req.getParameter("seller");

        // Create a new User object
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setLanguage(language);
        book.setPublisher(publisher);
        book.setSeller(seller);
        

        // Save book using Hibernate
        HibernateFactoryConfig.getbookDAO().insertBookDetails(book);

        // Redirect to the user list
        res.sendRedirect(req.getContextPath() + "/toAllBooks");
    }
	
}
