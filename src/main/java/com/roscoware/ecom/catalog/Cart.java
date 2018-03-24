package com.roscoware.ecom.catalog;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//Kasey is going to work on adding and removing items from the cart, then calculating the total price of the cart.

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	private HashSet<Product> products;
	
	static final double DEFAULT_CARTBALANCE = 0.00;
	protected double cartBalance = DEFAULT_CARTBALANCE;

	public Cart(double cartBalance, Product... products) {
		this.cartBalance = cartBalance;
		this.products = new HashSet<Product>(asList(products));
	}

	public Long getId() {
		return id;
	}
	
	public double getCartBalance() {
		return cartBalance;
	}

	public HashSet<Product> getProducts() {
		return products;
	}

	public void addProductToCart(Product product) {
		products.add(product);

	}

	public void removeProductFromCart(Product product) {
		products.remove(product);
	}

//	public void getPriceTotalOfCart() {
//		for (products)
//	}

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
