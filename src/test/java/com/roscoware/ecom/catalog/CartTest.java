package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CartTest {

	// Category testCategory = new Category("cat", "is cool");
	// Product product1 = new Product("", "", "", 2.00, testCategory, "");
	// Product product2 = new Product("", "", "", 3.00, testCategory, "");
	Cart testCart = new Cart(1, "Mister Anderson");

	@Test
	public void shouldReturnCartBalance() {
		assertThat(testCart.getCartTotal(), is(1.00));
	}

	@Test

	public void shouldReturnCustomerName() {
		assertThat(testCart.getCustomerName(), is("Mister Anderson"));
	}

}
