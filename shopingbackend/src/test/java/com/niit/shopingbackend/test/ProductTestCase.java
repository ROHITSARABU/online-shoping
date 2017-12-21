package com.niit.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingbackend.dao.ProductDAO;
import com.niit.shopingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;


	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
/*	@Test
	public void testCRUDProduct() {
		product = new Product();
		
		product.setName("Redmi note 4");
		product.setBrand("Redmi");
		product.setDescription("Description for Redmi note 4");
		product.setUnitPrice(15000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(1);
		
		assertEquals("Something went wrong while adding products",true,productDAO.add(product));
		
		//reading and updating the product
		product = productDAO.get(2);
		product.setName("google pixel");
		assertEquals("Something went wrong while adding products",true,productDAO.update(product));
		
		assertEquals("Something went wrong while deleting existing records",true,productDAO.delete(product));
		
		//list
		assertEquals("Something went wrong while fetching list of products",6,productDAO.list().size());
		
	}
	*/
	
	@Test
	public void testListOfActiveProducts(){
		assertEquals("Something went wrong while fetching list of products",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListOfActiveProductsByCategory(){
		assertEquals("Something went wrong while fetching list of products",1,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching list of products",2,productDAO.listActiveProductsByCategory(2).size());
		assertEquals("Something went wrong while fetching list of products",2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void tesGetLatestActiveProduct(){
		assertEquals("Something went wrong while fetching list of products",3,productDAO.getLatestActiveProducts(3).size());
		
	}


	
}

