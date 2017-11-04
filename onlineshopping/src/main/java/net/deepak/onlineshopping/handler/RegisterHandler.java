package net.deepak.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.deepak.onlineshopping.model.RegisterModel;
import net.deepak.shoppingbackend.dao.UserDAO;
import net.deepak.shoppingbackend.dto.Address;
import net.deepak.shoppingbackend.dto.Cart;
import net.deepak.shoppingbackend.dto.User;


//bean class
@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel rm,User usr){
		rm.setUser(usr);
	}
	
	
	public void addBilling(RegisterModel rm,Address add){
		rm.setBilling(add);
	}
	
	public String saveAll(RegisterModel rm){
		
		String tv="gotoSuccess";
		
		//fetch user
		User user =rm.getUser();
		
		if(user.getRole().equals("USER")){
			
			 Cart cart =new Cart();
			 cart.setUser(user);
			 user.setCart(cart);
		}
		//save the user
		userDAO.addUser(user);
		
		//get the address
		Address bill=rm.getBilling();
		//bill.setUserId(user.getId());
		bill.setBilling(true);
		
		//save address
		userDAO.addAddress(bill);
		
		
		return tv;
		
	}
	
	
	
}
