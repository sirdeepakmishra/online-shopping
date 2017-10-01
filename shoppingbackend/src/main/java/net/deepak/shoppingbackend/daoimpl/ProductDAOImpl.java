package net.deepak.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.deepak.shoppingbackend.dao.ProductDAO;
import net.deepak.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/************ SINGLE Product ****/
	@Override
	public Product get(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/************ LIst of Product ****/
	@Override
	public List<Product> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/************ INSERT Product ****/
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/************ UPDATE Product ****/
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/************ DELETE Product ****/
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active=:activeBatao";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("activeBatao", true).getResultList();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCAtegory = "FROM Product WHERE active=:activeBatao AND categoryId=:catID";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCAtegory, Product.class)
				.setParameter("activeBatao", true).setParameter("catID", categoryId).getResultList();

	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String activeProduct = "FROM Product WHERE active=:activeCheck ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(activeProduct, Product.class)
				.setParameter("activeCheck", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
