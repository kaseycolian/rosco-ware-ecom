package com.roscoware.ecom.catalog;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany 
	private Collection<Product> products;
	
	public Collection<Product> getProducts(){
		return products;
	}

	public Cart(Product... products) {
	this.products = new HashSet<>(asList(products));
	}

	public Long getId() {
		return id;
	}
	
	@SuppressWarnings("unused")
	private Cart() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Cart) obj).id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	

}
