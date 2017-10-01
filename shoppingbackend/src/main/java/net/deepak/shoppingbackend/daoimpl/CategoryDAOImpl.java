package net.deepak.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.deepak.shoppingbackend.dao.CategoryDAO;
import net.deepak.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	public SessionFactory sessionFactory;

	/*
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
	}*/
	
	
	@Override
	public List<Category> list() {
	String selectActiveCategory="FROM Category WHERE  active =:active";
		
	Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
	
	query.setParameter("active", true);
	//return cat;
		return query.getResultList();
	}

/*****getting single category based in ID*****/
	@Override
	public Category getMethod(int id) {
		/*for(Category ct: cat){
			if(ct.getId()==id)
			{return ct;}
			
		}*/
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
	}


	@Override
	
	public boolean add(Category category) {

		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);;
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
					}
	}

/*   updating single category*/ 
	@Override
	public boolean update(Category category) {
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);;
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
					}
	}


	@Override
	public boolean delete(Category category) {
		category.setActive(false);;
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().update(category);;
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
					}
	}

}
