package net.deepak.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.deepak.shoppingbackend.dao.CategoryDAO;
import net.deepak.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
private static	List<Category> cat=new ArrayList<Category>();
	

	
	static {
		Category c=new Category();
		c.setId(1);
		c.setName("Mobile");
		c.setDescription("Apple Mobile");
		c.setActive(true);
		c.setImageURL("cat1.png");
		cat.add(c);
		
		 c=new Category();
		c.setId(2);
		c.setName("TV");
		c.setDescription("Panasonic TV");
		c.setActive(true);
		c.setImageURL("cat2.png");
		cat.add(c);
		
		
		
		 c=new Category();
		c.setId(3);
		c.setName("Laptop");
		c.setDescription("Samsung Laptop");
		c.setActive(true);
		c.setImageURL("cat3.png");
		cat.add(c);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return cat;
	}


	@Override
	public Category getMethod(int id) {
		for(Category ct: cat){
			if(ct.getId()==id)
			{return ct;}
			
		}
		return null;
		
	}

}
