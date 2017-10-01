package net.deepak.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.deepak.shoppingbackend.dao.ProductDAO;
import net.deepak.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("net.deepak.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	/*@Test
	public void testCRUDProduct(){
		
		//create operation
		product =new Product();
		product.setName("OPPO selfi s3");
		product.setBrand("Oppo");
		product.setDescription("description  of oppo mobile !!!");
		product.setUnitPrice(23000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something went wrong while inserting product!",true,productDAO.add(product));
		
		//reading and updating category
		product=productDAO.get(2);
		product.setName("Samsung GALAXY S7");
		assertEquals("something went wrong while updating product!",true,productDAO.update(product));
		
		assertEquals("something went wrong while deleting product!",true,productDAO.delete(product));
		
		//list
		assertEquals("something went wrong while fetching product!",6,productDAO.list().size());
	}*/
	
	@Test
	public void testListActiveProducts(){
		assertEquals("something went wrong while fetching product!",5,productDAO.listActiveProducts().size());
		}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("something went wrong while fetching product!",3,productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("something went wrong while fetching product!",2,productDAO.listActiveProductsByCategory(1).size());
		
	
	}
	
	

	@Test
	public void testgetLatestActiveProducts(){
		assertEquals("something went wrong while fetching product!",3,productDAO.getLatestActiveProducts(3).size());
		}

	
	
	
	
	
}
