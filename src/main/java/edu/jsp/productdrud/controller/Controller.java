package edu.jsp.productdrud.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.productcrud.model.Product;

public class Controller {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("product");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public boolean addProduct(Product product) {
		if (product != null) {
			transaction.begin();
			manager.persist(product);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Product findProduct(int id) {
		if (id != 0) {
			Product product = manager.find(Product.class, id);
			return product;
		} else {
			return null;
		}
	}

	public boolean updateProduct(int id, Product product) {
		Product product2 = manager.find(Product.class, id);
		if (product2 != null) {
			product2.setName(product.getName());
			product2.setType(product.getType());
			product2.setPrice(product.getPrice());
			transaction.begin();
			manager.merge(product2);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteProduct(int id) {
		Product product = manager.find(Product.class, id);
		if (id != 0 && product != null) {
			transaction.begin();
			manager.remove(product);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
