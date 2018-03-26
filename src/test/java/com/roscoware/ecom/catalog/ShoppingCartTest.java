package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Before;
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
	public void shouldReturnId() {
		Long id = underTest.getId();
		assertThat(id, is(0L));
	}

	@Test
	public void shouldAddACartItem() {
		underTest.addCartItem(cartItem1);
		Collection<CartItem> result = underTest.getCartItems();
		assertThat(result, hasItems(cartItem1));
	}

	@Test
	public void shouldAddTwoCartItemsAndRemoveTheFirstItemFromShoppingCart() {
		underTest.addCartItem(cartItem1);
		underTest.addCartItem(cartItem2);
		underTest.removeCartItem(cartItem1);
		assertThat(underTest.getCartItems(), containsInAnyOrder(cartItem2));

	}

	@Test
	public void shouldReturnTotalOfAllShoppingCartItemsTotalling475() {
		underTest.addCartItem(cartItem1);
		underTest.addCartItem(cartItem2);
		double result = underTest.getTotalCostOfCartItems();
		assertEquals(result, 4.75, .001);

	}

	@Test
	public void shouldReturnTotalOfAllShoppingCartItemTotalling525() {
		underTest.addCartItem(cartItem2);
		underTest.addCartItem(cartItem3);
		double result = underTest.getTotalCostOfCartItems();
		assertEquals(result, 5.25, .001);

	}
}
