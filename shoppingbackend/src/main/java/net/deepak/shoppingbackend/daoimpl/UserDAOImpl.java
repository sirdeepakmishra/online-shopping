package net.deepak.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.deepak.shoppingbackend.dao.UserDAO;
import net.deepak.shoppingbackend.dto.Address;
import net.deepak.shoppingbackend.dto.Cart;
import net.deepak.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addUser(User user) {
		try {

			sf.getCurrentSession().persist(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addAddress(Address address) {
		try {

			sf.getCurrentSession().persist(address);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addCart(Cart cart) {
		try {

			sf.getCurrentSession().persist(cart);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {

			sf.getCurrentSession().update(cart);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User getByEmail(String email) {
		String hql="FROM User where email=:em";
		
	try{
return sf.getCurrentSession().createQuery(hql,User.class).setParameter("em", email).getSingleResult();
		
	}
	catch(Exception e)
	{e.printStackTrace();
	return null;
	}
		
	}

	@Override
	public Address getBillingAddress(User user) {
	String hql="FROM Address WHERE user=:u AND billing=:bill";
	
	try{
		return sf.getCurrentSession().createQuery(hql,Address.class)
				.setParameter("u", user).setParameter("bill", true).getSingleResult();
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
		
	}
		
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String hql="FROM Address WHERE user=:u AND shipping=:ship";
		
		try{
			return sf.getCurrentSession().createQuery(hql,Address.class)
					.setParameter("u", user).setParameter("ship", true).getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

}
