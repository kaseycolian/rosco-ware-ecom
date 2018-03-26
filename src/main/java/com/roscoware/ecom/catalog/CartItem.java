package com.roscoware.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

// One Product to Many CartItems

// CartItem will have id, product, and int quantity
@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private long id;

	// One Product To Many CartItems
	// Many CartItems with One Product
	@ManyToOne
	@JsonIgnore
	private Product product;
	private int quantityOfIndividualProduct;
	@ManyToOne
	@JsonIgnore
	private ShoppingCart shoppingCart;

	public CartItem(Product product, int quantityOfIndividualProduct, ShoppingCart cart) {
		this.product = product;
		this.quantityOfIndividualProduct = quantityOfIndividualProduct;
		this.shoppingCart = cart;
	}

	public long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantityOfIndividualProduct() {
		return quantityOfIndividualProduct;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public String getProductName() {
		return product.getName();
	}
	
	public double getLineItemTotal() {
		double lineItemTotal = quantityOfIndividualProduct * getProduct().getPrice();
		return lineItemTotal;
	}

	public CartItem() {

	}

	@Override
	public String toString() {
		return product.getName() + ":" + quantityOfIndividualProduct;
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
