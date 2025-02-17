package com.hibernateCrud.CRUD_hibernate.controllers;

import java.io.IOException;

import com.hibernateCrud.CRUD_hibernate.configFactory.HibernateFactoryConfig;
import com.hibernateCrud.CRUD_hibernate.entities.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateBook")
public class UpdateBookController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Form data is fetched
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String language = req.getParameter("language");
        String publisher = req.getParameter("publisher");
        String seller = req.getParameter("seller");
        
        Book book = new Book(name, author, language, publisher, seller);

        // Save updated user
        HibernateFactoryConfig.getbookDAO().updateBookDetails(book, id);

        // Redirect to the user list
        res.sendRedirect(req.getContextPath() + "/toAllBooks");
    }
    
}
