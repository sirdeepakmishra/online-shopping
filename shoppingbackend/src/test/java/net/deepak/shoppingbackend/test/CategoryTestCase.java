package net.deepak.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.deepak.shoppingbackend.dao.CategoryDAO;
import net.deepak.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO ;
	private Category category;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("net.deepak.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	
/*	@Test
	public void testAddCategory(){
		
		category =new Category();
		category.setName("Laptop");
		category.setDescription("Dell Laptop description");
		
		category.setImageURL("cat3.png");
		assertEquals("Successfully added a category inside table!!",true,categoryDAO.add(category));
		
		
	}*/
	
/*	@Test
	public void testGetCategory(){
		
		category=categoryDAO.getMethod(2);
		assertEquals("Successfully fetched single  category from table!!","Telvision",category.getName());
	}*/
	
	
	/*@Test
	public void testUpdateCategory(){
		
		category=categoryDAO.getMethod(2);
		category.setName("TV");
		assertEquals("Successfully update single  category in table!!",true,categoryDAO.update(category));
	
	}*/
	
	
	/*@Test
	public void testDeleteCategory(){
		
		category=categoryDAO.getMethod(2);
		
		assertEquals("Successfully delete single  category in table!!",true,categoryDAO.delete(category));
	
	}*/
	
	
	
	/*@Test
	public void testListCategory(){
		
		assertEquals("Successfully fetch list of  categories from table!!",2,categoryDAO.list().size());
	}*/
	
	
	@Test
	public void testCRUDCategory(){
		
		//add operation
		
		category =new Category();
		category.setName("Laptop");
		category.setDescription("Dell Laptop description");
		category.setImageURL("cat3.png");
		
		assertEquals("Successfully added a category inside table!!",true,categoryDAO.add(category));
		 
		
		category =new Category();
		category.setName("Television");
		category.setDescription("Television description");
		category.setImageURL("cat3.png");
		
		assertEquals("Successfully added a category inside table!!",true,categoryDAO.add(category));
		 
		
		//fetch and update
		category=categoryDAO.getMethod(2);
		category.setName("TV");
		assertEquals("Successfully update single  category in table!!",true,categoryDAO.update(category));
	
		//delete
		assertEquals("Successfully delete single  category in table!!",true,categoryDAO.delete(category));
	
		//fetch list
		assertEquals("Successfully fetch list of  categories from table!!",1,categoryDAO.list().size());
		
		
	}
	
	
	
}
