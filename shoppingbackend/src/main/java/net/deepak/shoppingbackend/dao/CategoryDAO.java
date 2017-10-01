package net.deepak.shoppingbackend.dao;

import java.util.List;

import net.deepak.shoppingbackend.dto.Category;

public interface CategoryDAO {
	

	Category getMethod(int id);
	List<Category> list();
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

}
