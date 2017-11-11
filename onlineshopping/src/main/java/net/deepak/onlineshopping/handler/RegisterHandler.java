package net.deepak.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;
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
	
	
	public String validateUser(User user,MessageContext error){
		String transitionValue="retunSuccess";
	
		//password match checking
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password doesn't match the confirm password!")
					.build()
					);
			System.out.println("inside password");
			 transitionValue="retunFailure";
		}
	 
		//uniqueness of email
			if(userDAO.getByEmail(user.getEmail())!=null){
			
			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Email address is already used!")
					.build()
					);
			
			System.out.println("inside email");
			 transitionValue="retunFailure";
		}
			

			System.out.println("inside method");
		
		return transitionValue;
		
	
	
	}
	
	public String saveAll(RegisterModel rm){
		
		String transitionValue="gotoSuccess";
		
		//fetch user
		User user =rm.getUser();
		
		if(user.getRole().equals("USER")){
			
			 Cart cart =new Cart();
			 cart.setUser(user);
			 user.setCart(cart);
		}
		//save the user
		userDAO.addUser(user);
		
		//SAVE  the BILLING  address
		Address bill=rm.getBilling();
		bill.setUserId(user.getId());
		bill.setBilling(true);
		
		//save address
		userDAO.addAddress(bill);
		
		
		return transitionValue;
		
	}
	
	
	
	
	
	
}
