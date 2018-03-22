package com.roscoware.ecom.catalog;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@RequestMapping("/products")
	public Collection<Product> getProducts() {

		return Collections.singleton(new Product("rosco shorts"));
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable(name = "id") long id) {
		return new Product("Rosco shorts");
	}

}
