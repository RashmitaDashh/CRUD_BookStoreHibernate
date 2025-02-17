package com.hibernateCrud.CRUD_hibernate.controllers;

import java.io.IOException;

import com.hibernateCrud.CRUD_hibernate.configFactory.HibernateFactoryConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class DeleteBookController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Fetch user ID from form
        int id = Integer.parseInt(req.getParameter("id"));

        // Delete the user
        HibernateFactoryConfig.getbookDAO().deleteBookDetails(id);

        // Redirect to the user list
        res.sendRedirect(req.getContextPath() + "/toAllBooks");
    }
}
