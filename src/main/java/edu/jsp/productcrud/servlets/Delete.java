package edu.jsp.productcrud.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.productdrud.controller.Controller;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class Delete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		Controller controller = new Controller();
		if (controller.deleteProduct(id)) {
			resp.getWriter().write("<h1>Product Deleted</h1>");
		}

	}

}
