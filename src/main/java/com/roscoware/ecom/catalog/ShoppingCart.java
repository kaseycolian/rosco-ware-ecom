package com.roscoware.ecom.catalog;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy = "shoppingCart")
	private Collection<CartItem> cartItems;

	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);

	}

	public ShoppingCart(CartItem... cartItems) {
		this.cartItems = new HashSet<>(asList(cartItems));

	}

	private ShoppingCart() {
	}

	public Long getId() {
		return id;
	}

	public Collection<CartItem> getCartItems() {

		return cartItems;
	}

	public void removeCartItem(CartItem cartItem1) {
		cartItems.remove(cartItem1);
	}

	public double totalCartItems() {
		double cartTotal = 0.0;
		for (CartItem cartItem : cartItems) {
			cartTotal += cartItem.getQuantityOfIndividualProduct() * cartItem.getProduct().getPrice();
		}
		return cartTotal;
	}

}
