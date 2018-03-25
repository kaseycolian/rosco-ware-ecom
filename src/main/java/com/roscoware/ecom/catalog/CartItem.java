package com.roscoware.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// One Product to Many CartItems

// CartItem will have id, product, and int quantity
@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private Long id;

	//One Product To Many CartItems
	//Many CartItems with One Product
	@ManyToOne
	private Product product;
	private int quantityOfIndividualProduct;

	public CartItem(Product product, int quantityOfIndividualProduct) {
		this.product = product;
		this.quantityOfIndividualProduct = quantityOfIndividualProduct;
	}
	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantityOfIndividualProduct() {
		return quantityOfIndividualProduct;
	}
	
	public CartItem() {
		
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((CartItem) obj).id;
	}

}
