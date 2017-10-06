package net.deepak.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.deepak.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product product = (Product) target;

		// check1:: whether file has been selected or not
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please Select an Image file to Upload!!");
			return;
		}

		// check2:: file type
		if (!(
				product.getFile().getContentType().equals("image/jpeg")
			|| product.getFile().getContentType().equals("image/png")
			|| product.getFile().getContentType().equals("image/gif")
			)
				
			) {

			errors.rejectValue("file", null, "Only image for upload is permissible!!");
			return;
		}

	}

}
