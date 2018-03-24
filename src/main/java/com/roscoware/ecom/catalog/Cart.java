package com.roscoware.ecom.catalog;

import java.util.HashSet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import static java.util.Arrays.asList;

import java.util.Collection;

public class Cart {
	
	@Id
	@GeneratedValue
	private long id;

	@ManyToMany(mappedBy = "cart")
	private Collection<Product> products;
	
	public Collection<Product> getProducts(){
		return products;
	}

	public Cart(Product... products) {
	this.products = new HashSet<>(asList(products));
	}

	public long getId() {
		return id;
	}

	

}
