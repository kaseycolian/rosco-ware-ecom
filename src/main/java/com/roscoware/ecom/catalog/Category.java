package com.roscoware.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private Collection<Product> products;

	public Category(String name, String description) {
		this.name = name;
		this.description = description;

	}

	@SuppressWarnings("unused")
	private Category() {
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public String getDescription() {

		return description;
	}

	public Collection<Product> getProducts() {

		return products;
	}

	@Override
	public String toString() {
		return name + " | " + description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Category) obj).id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}
}
