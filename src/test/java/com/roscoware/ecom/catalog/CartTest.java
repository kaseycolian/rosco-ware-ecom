package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;

public class CartTest {

//Kasey is working on adding and removing items from the cart, then calculating the total price of cart.	
	
	@Resource
	private CartRepository cartRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ProductRepository productRepo;
	
	Category testCategory = new Category("cat", "is cool");
	Product product1 = new Product("", "", "", 1.00, testCategory, "");
	Cart testCart = new Cart(product1);

	// @Test
	// public void shouldReturnProduct() {
	// Category testCategory = new Category("chickpeas", "declicious");
	// testCategory = categoryRepo.save(testCategory);
	//
	// Product testProduct = new Product("", "", "", 5, testCategory, "");
	// testProduct = productRepo.save(testProduct);
	// Cart underTest = new Cart(testProduct);
	// underTest = cartRepo.save(underTest);
	//
	//// underTest.getProducts();
	//
	// assertThat(product, is(testProduct));
	//
	// }

	@Test
	public void shouldGetTotalOfOneItem() {
		// product1.getPrice();
		assertThat(product1.getPrice(), is(1.00));

	}
	
//	@Test 
//	public void shouldGetTotalOfTwoItems() {
//		assertThat(testCart.getTotal(), is (1.00));
//		
//	}

}
