package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;

public class CartTest {

	
	@Resource
	private CartRepository cartRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private ProductRepository productRepo;
	
	Category testCategory = new Category("cat", "is cool");
	Product product1 = new Product("", "", "", 2.00, testCategory, "");
	Product product2 = new Product("", "", "", 3.00, testCategory, "");
	Cart testCart = new Cart(1, product1);

	
	@Test
	public void shouldReturnCartBalance() {
		assertThat(testCart.getCartBalance(), is(1.00));
	}

	
//	@Test
//	public void shouldGetTotalNumberOfItemsInCart() {
//		int originalQuantityOfProducts = testCart.getProducts().size();
//		testCart.addProductToCart(product2);
//		int updatedQuantityOfProducts = testCart.getProducts().size();
//		assertThat(updatedQuantityOfProducts-originalQuantityOfProducts, is(1));
//	}

}
