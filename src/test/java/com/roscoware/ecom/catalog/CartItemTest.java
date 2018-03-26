package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CartItemTest {

	Category testCategory = new Category("stuff", "fun");
	Product testProduct = new Product("cat", "", "", 5.00, testCategory, "");
	ShoppingCart testCart = new ShoppingCart();
	CartItem underTest = new CartItem(testProduct, 2, testCart);

	@Test
	public void shouldReturnQuantityOfIndividualProdudct() {
		int itemQuantity =  underTest.getQuantityOfIndividualProduct();
		assertThat(itemQuantity, is(2));
	}
	
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
	public void shouldReturnProductName() {
		String productName = underTest.getProductName();
		assertThat(productName, is("cat"));
	}
}
