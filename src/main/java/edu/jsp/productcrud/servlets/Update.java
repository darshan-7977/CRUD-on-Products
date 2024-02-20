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
@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		double price = Double.valueOf(req.getParameter("price"));
		Product product = new Product();
		product.setName(name);
		product.setType(type);
		product.setPrice(price);
		Controller controller = new Controller();
		controller.updateProduct(id, product);

		PrintWriter writer = resp.getWriter();
		writer.write("<h1>Product Updated Successfully</h1>");
	}
}
