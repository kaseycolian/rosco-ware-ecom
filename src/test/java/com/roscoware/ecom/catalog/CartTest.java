package com.roscoware.ecom.catalog;

import org.junit.Test;

public class CartTest {

	@Test
	public void shouldAddProductWhenUserAddsProduct() {
		Product product1 = new Product("leash");
		Product product2 = new Product("collar");
		Cart underTest = new Cart(product1);
		// assertThat(underTest, contains(product1));

	}

}
