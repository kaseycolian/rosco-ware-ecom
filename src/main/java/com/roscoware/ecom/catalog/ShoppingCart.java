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
	private long id;
	@OneToMany(mappedBy = "shoppingCart")
	private Collection<CartItem> cartItems;

	public ShoppingCart(CartItem... cartItems) {
		this.cartItems = new HashSet<>(asList(cartItems));
	}

	public long getId() {
		return id;
	}

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);

	}

	public void removeCartItem(CartItem cartItem1) {
		cartItems.remove(cartItem1);
	}

	@SuppressWarnings("unused")
	private ShoppingCart() {
	}

	public double getTotalCostOfCartItems() {
		double cartTotal = 0.0;
		for (CartItem cartItem : cartItems) {
			cartTotal += cartItem.getQuantityOfIndividualProduct() * cartItem.getProduct().getPrice();
		}
		return cartTotal;
	}

}
