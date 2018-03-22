package com.roscoware.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private long id;
	private String name;

	public Product(String name) {
		this.name = name;
	}

	@SuppressWarnings("unused")
	private Product() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
