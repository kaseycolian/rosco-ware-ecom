package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ShoppingCartTest {
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private ProductRepository productRepo;
	@Resource
	private CartItemRepository cartItemRepo;

	@Test
	public void shouldAddACartItem() {
		Category category = new Category("Category", "Category Description");
		category = categoryRepo.save(category);
		Product product = new Product("Product", "Product2", "Product3", 1.25, category, "image");
		product = productRepo.save(product);
		CartItem cartItem = new CartItem(product, 2);
		cartItem = cartItemRepo.save(cartItem);
		ShoppingCart underTest = new ShoppingCart();
		underTest.addCartItem(cartItem);
		HashSet<CartItem> result = underTest.getCartItems();
		assertThat(result, hasItems(cartItem));

	}

	@Test
	public void shouldAddTwoCartItemsAndRemoveTheFirstItemFromShoppingCart() {

	}

}
