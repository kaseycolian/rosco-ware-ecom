package com.roscoware.ecom.catalog;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CartItemTest {

	Category testCategory = new Category("stuff", "fun");
	Product testProduct = new Product("cat", "", "", 5.00, testCategory, "");
	ShoppingCart testCart = new ShoppingCart();
	CartItem underTest = new CartItem(testProduct, 2, testCart);

	@Test
	public void shoudldReturnId() {
		Long id = underTest.getId();
		assertThat(id, is(0L));
	}

	@Test
	public void shouldReturnProduct() {
		Product product = underTest.getProduct();
		assertThat(product, is(testProduct));
	}

	@Test
	public void shouldReturnQuantityOfIndividualProduct() {
		int itemQuantity = underTest.getQuantityOfIndividualProduct();
		assertThat(itemQuantity, is(2));
	}

	@Test
	public void shouldReturnShoppingCart() {
		ShoppingCart cart = underTest.getShoppingCart();
		assertThat(cart, is(cart));
	}

	@Test
	public void shouldReturnProductName() {
		String productName = underTest.getProductName();
		assertThat(productName, is("cat"));
	}

	@Test
	public void shouldGetLineItemTotal() {
		double itemTotal = underTest.getLineItemTotal();
		assertEquals(itemTotal, 10, 001);
	}
}
