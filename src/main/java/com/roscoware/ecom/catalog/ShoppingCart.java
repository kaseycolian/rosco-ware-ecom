package com.roscoware.ecom.catalog;

import java.util.HashSet;

public class ShoppingCart {

	private HashSet<CartItem> cartItems = new HashSet<>();

	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);

	}

	public HashSet<CartItem> getCartItems() {

		return cartItems;
	}

}
