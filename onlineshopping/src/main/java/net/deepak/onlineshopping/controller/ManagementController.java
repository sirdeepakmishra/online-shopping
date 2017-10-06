package net.deepak.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.deepak.onlineshopping.util.FileUploadUtility;
import net.deepak.onlineshopping.validator.ProductValidator;
import net.deepak.shoppingbackend.dao.CategoryDAO;
import net.deepak.shoppingbackend.dao.ProductDAO;
import net.deepak.shoppingbackend.dto.Category;
import net.deepak.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO catDAO;
	@Autowired
	private ProductDAO proDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="opt",required=false) String operation	){
		
		ModelAndView mv =new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product nProduct =new Product();
		
		//set field for admin
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("productFromMC",nProduct);
		
		if(operation!=null){
			if(operation.equals("productStatus")){
				
				mv.addObject("msg","Product Submitted Successfully!");
			}
			else if(operation.equals("categoryStatus")){
				
				mv.addObject("msg","Category Submitted Successfully!");
			}
			
		}
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
public ModelAndView showEditProduct(@PathVariable int id	){
		
		ModelAndView mv =new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		//fetch the product from database
		Product nProduct =proDAO.get(id);
		
		//set the product fetch from the database
		mv.addObject("productFromMC",nProduct); 
		return mv;
	}
	
	
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid  @ModelAttribute("productFromMC") Product mProduct,
			BindingResult results,Model model,HttpServletRequest request){
		
		
		//handle image validation for new product
		if(mProduct.getId()==0){
		new ProductValidator().validate(mProduct, results);
		}else{
			//handle image validation for existing product
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		//check if there is any error
		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("msgWarn","Product Submittion Failed");
			//model.addAttribute("msg","Product Submittion Failed");
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		if (mProduct.getId()==0){
			//create a new product record if it is 0
			proDAO.add(mProduct);	
		}
		else{//update product if id is not 0
			proDAO.update(mProduct);	
		}
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
			
		}
		
		return "redirect:/manage/products?opt=productStatus";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody  //convert automatically to json @ResponseBody
	public String handleProductActivation(@PathVariable int id){
		
		//is going to fetch the product from the database
		Product pro=proDAO.get(id);
		boolean isActive=pro.isActive();
		//activation and deActivation based on the value of active field
		pro.setActive(!pro.isActive());
		//updating the product
		proDAO.update(pro);
		
		return (isActive)?
				"You have deactivated the product with id" + pro.getId()
				 :"You have Activated the product with id" + pro.getId();
	}
	
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categoriesForMPjsp")
	public List<Category> getCategories(){
		return catDAO.list();
	}
	
	
	//handle category submission
	@RequestMapping( value=	"/category" , method=RequestMethod.POST)	
	public String handleCategorySubmission(@ModelAttribute Category category){
		//add the new category
		catDAO.add(category);
		return "redirect:/manage/products/?opt=categoryStatus";
	}
	
	
	//handling modal
@ModelAttribute("category")
public Category getCategory(){
	return new Category();
}





	

}
