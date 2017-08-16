package net.deepak.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.deepak.shoppingbackend.dao.CategoryDAO;
import net.deepak.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		/* passing the list of categories */
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	/*
	 * Method to load all the product and based on category
	 * */
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		/* passing the list of categories */
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")  int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//category DAO to fetch single category
		Category cat= categoryDAO.getMethod(id);
		
		mv.addObject("title", cat.getName());
		/* passing the list of categories */
		mv.addObject("categories", categoryDAO.list());
		/* passing the single category object*/
		mv.addObject("singleCategory", cat);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/// ****************************************************************************8///
	@RequestMapping(value = "/test2")
	public ModelAndView test2(@RequestParam(value = "greeting", required = false) String greeting) {
		if (greeting == null) {

			greeting = "deepak2";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if (greeting == null) {

			greeting = "deepak";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

}
