package net.deepak.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.deepak.shoppingbackend.dao.UserDAO;
import net.deepak.shoppingbackend.dto.Address;
import net.deepak.shoppingbackend.dto.Cart;
import net.deepak.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user=new User();
	private Address address=null;
	private Cart cart=new Cart();
	
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("net.deepak.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void testGetAddressess(){
		
		user=userDAO.getByEmail("dm@gmial.com");
		
		assertEquals("failed to fetch the list of address and size not match",2,
				userDAO.listShippingAddresses(user).size());
		
		assertEquals("failed to fetch the billing address and size not match","lucknow",
				userDAO.getBillingAddress(user).getCity());
	}
	
/*	@Test
	public void testAddAddress(){
		
		user=userDAO.getByEmail("dm@gmial.com");
		 address=new Address();
		address.setAddressLineOne("e 4501");
		address.setAddressLineTwo("aliganj");
		address.setCity("kanpur");
		address.setState("UP");
		address.setCountry("INDIA");
		address.setPostalCode("226645");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		assertEquals("failed to add the address", true,userDAO.addAddress(address));
	}*/
	
	/*@Test
	public void testAddAddress(){
		
		//we need to add the user
		user=new User();
		user.setFirstName("deepak");
		user.setLastName("mishra");
		user.setEmail("dm@gmial.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("123");
		
		//add the user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		//we need to add the address
		
		 address=new Address();
		address.setAddressLineOne("e 4499");
		address.setAddressLineTwo("rajaji puram");
		address.setCity("lucknow");
		address.setState("UP");
		address.setCountry("INDIA");
		address.setPostalCode("226017");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		assertEquals("failed to add the address", true,userDAO.addAddress(address));

		//we need to add the shipping address
		
		 address=new Address();
			address.setAddressLineOne("cdac");
			address.setAddressLineTwo("b block");
			address.setCity("noida");
			address.setState("UP");
			address.setCountry("INDIA");
			address.setPostalCode("201307");
			//set shipping true
			address.setShipping(true);
			
			//attach the user to the address
			address.setUser(user);
			assertEquals("failed to add the shipping address", true,userDAO.addAddress(address));
	
	}*/
	
	
	
/*	@Test
	public void testUpdateCart(){
		
		//fetch the user by its email
		user=userDAO.getByEmail("dm@gmial.com");
		
		//get the cart of the user
		cart=user.getCart();
		
		cart.setGrandTotal(555);
		cart.setCartLines(2);
		assertEquals("fail to update the cart", true,userDAO.updateCart(cart));
		
		
	}*/
	
	
	
	/*@Test
	public void testAdd(){
		user=new User();
		user.setFirstName("deepak");
		user.setLastName("mishra");
		user.setEmail("dm@gmial.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("123");

		
		if(user.getRole().equals("USER")){
			
			 //create cart for this user
			cart =new Cart();
			//cart.setUserId(user.getId());
			cart.setUser(user);
			//attach the cart with user
			user.setCart(cart);
			
		}
		
		//add the user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		
	}*/
	
	
	
	
	
	
	
	/*@Test
	public void testAdd(){
		
		user.setFirstName("deepak");
		user.setLastName("mishra");
		user.setEmail("dm@gmial.com");
		user.setContactNumber("123456789");
		user.setRole("USER");
		user.setPassword("123");
		
		//add the user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		
		 address=new Address();
		address.setAddressLineOne("e 4499");
		address.setAddressLineTwo("rajaji puram");
		address.setCity("lucknow");
		address.setState("UP");
		address.setCountry("INDIA");
		address.setPostalCode("226017");
		address.setBilling(true);
		
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("failed to add address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			
			 //create cart for this user
			
			//cart.setUserId(user.getId());
			cart.setUser(user);
			//add the cart
			assertEquals("failed to add cart",true,userDAO.addCart(cart));
			
			//add the shipping address for this user
			 address=new Address();
			address.setAddressLineOne("cdac");
			address.setAddressLineTwo("b block");
			address.setCity("noida");
			address.setState("UP");
			address.setCountry("INDIA");
			address.setPostalCode("201307");
			//set shipping true
			address.setShipping(true);
			
			//link it with user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("failed to add shipping address",true,userDAO.addAddress(address));
			
		}
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	

}
