package edu.jsp.productcrud.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.productcrud.model.Product;
import edu.jsp.productdrud.controller.Controller;

@SuppressWarnings("serial")
@WebServlet("/read")
public class Read extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));

		Controller controller = new Controller();
		Product product = controller.findProduct(id);
		String name = product.getName();
		String type = product.getType();
		double price = product.getPrice();

		PrintWriter writer = resp.getWriter();

		writer.write("<h1>" + id + "<br>" + name + "<br>" + type + "<br>" + price + "</h1>");

	}
}
