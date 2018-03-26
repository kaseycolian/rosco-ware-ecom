package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CartItemTest {

	@Test
	public void shouldReturnQuantityOfIndividualProdudct() {
		Category testCategory = new Category ("stuff", "fun");
		Product testProduct = new Product ("", "", "", 5.00, testCategory, "");
		ShoppingCart testCart = new ShoppingCart();
		CartItem underTest = new CartItem(testProduct, 2, testCart);
		int itemQuantity =  underTest.getQuantityOfIndividualProduct();
		assertThat(itemQuantity, is(2));
	}
	
}
