package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BrowseController {
	@Resource
	private ProductRepository productRepo;
	@Resource
	private CategoryRepository categoryRepo;

	@RequestMapping("/products")
	public Iterable<Product> findProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/categories")
	public Iterable<Category> findCategories() {

		return categoryRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product findProduct(@PathVariable(name = "id") long id) {
		Product selectedProduct = productRepo.findOne(id);
		if (selectedProduct != null) {
			return selectedProduct;
		}
		throw new ProductNotFoundException();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException {

		/**
		 * I can honestly say I don't know what the following is for, review with
		 * instructors before Monday. -Ben
		 */
		private static final long serialVersionUID = 1390319315276294727L;

	}

}
