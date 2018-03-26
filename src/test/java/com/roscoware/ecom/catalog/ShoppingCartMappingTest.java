package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ShoppingCartMappingTest {
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private ProductRepository productRepo;
	@Resource
	private CartItemRepository cartItemRepo;
	private Category category;
	private Product product;
	private ShoppingCart underTest;
	private CartItem cartItem1;
	private Product product2;
	private CartItem cartItem2;
	private Product product3;
	private CartItem cartItem3;

	@Before
	public void setup() {
		category = new Category("Category", "Category Description");
		category = categoryRepo.save(category);
		product = new Product("Product", "Product2", "Product3", 1.25, category, "image");
		product = productRepo.save(product);
		underTest = new ShoppingCart();
		cartItem1 = new CartItem(product, 2, underTest);
		cartItem1 = cartItemRepo.save(cartItem1);
		product2 = new Product("Product2", "Productdsf2", "Productadsf3", .75, category, "image");
		product2 = productRepo.save(product2);
		cartItem2 = new CartItem(product2, 3, underTest);
		cartItem2 = cartItemRepo.save(cartItem2);
		product3 = new Product("Product3", "Productdsf2", "Productadsf3", 1.50, category, "image");
		product3 = productRepo.save(product3);
		cartItem3 = new CartItem(product3, 2, underTest);
		cartItem3 = cartItemRepo.save(cartItem3);
	}

	@Test
	public void shouldSaveOneShoppingCartWithManyCartItems() {

	}

}
