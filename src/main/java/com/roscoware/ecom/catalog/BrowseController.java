package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {
	@Resource
	private CrudRepository<Product, Long> productRepo;

	@RequestMapping("/products")
	public Iterable<Product> getProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable(name = "id") long id) {
		return productRepo.findOne(id);
	}

}
