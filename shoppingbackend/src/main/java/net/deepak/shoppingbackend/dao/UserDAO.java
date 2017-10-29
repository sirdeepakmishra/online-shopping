package net.deepak.shoppingbackend.dao;

import java.util.List;

import net.deepak.shoppingbackend.dto.Address;
import net.deepak.shoppingbackend.dto.Cart;
import net.deepak.shoppingbackend.dto.User;

public interface UserDAO {

	
	//add user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add address
		boolean addAddress(Address address);
		//alternative
		//Address getBillingAddress(int userId);
		//List <Address> listShippingAddresses(int userId);		
		
		Address getBillingAddress(User user);
		List <Address> listShippingAddresses(User user);
		
		//add cart
		boolean addCart(Cart cart);
		
		//update cart
		boolean updateCart(Cart cart);
	
}
