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
