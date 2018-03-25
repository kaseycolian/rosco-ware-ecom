package com.roscoware.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String type;
	private String description;
	private double price;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private Collection<CartItem> cartItems;
	
	@JsonIgnore
	@ManyToOne
	private Category category;
	private String imageUrl;

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	public Product(String name) {
		this.name = name;
	}

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name, String type, String description, double price, Category category, String imageUrl) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Product) obj).id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public String toString() {
		return name + " | " + category.getName();
	}
}