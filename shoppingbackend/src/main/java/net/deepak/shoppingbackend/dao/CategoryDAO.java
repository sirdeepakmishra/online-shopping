package net.deepak.shoppingbackend.dao;

import java.util.List;

import net.deepak.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category getMethod(int id);

}
