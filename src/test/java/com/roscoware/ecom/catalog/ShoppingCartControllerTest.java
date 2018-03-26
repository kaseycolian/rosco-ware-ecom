package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShoppingCartControllerTest {

	@InjectMocks
	private ShoppingCartController underTest;
	@Mock
	private ProductRepository productRepo;
	@Mock
	private CategoryRepository categoryRepo;
	@Mock
	private CartItemRepository cartItemRepo;
	@Mock
	private ShoppingCartRepository shoppingCartRepo;
	@Mock
	private Product product;
	@Mock
	private Category category;
	@Mock
	private CartItem cartItem;
	@Mock
	private ShoppingCart shoppingCart;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrieveOneShoppingCartContents() {
		when(shoppingCartRepo.findOne(42L)).thenReturn(shoppingCart);
		ShoppingCart result = underTest.findShoppingCart(42L);
		assertThat(result, is(shoppingCart));

	}

	@Test
	public void shouldRetrieveAllShoppingCartContents() {
		when(shoppingCartRepo.findAll()).thenReturn(Collections.singleton(shoppingCart));
		Iterable<ShoppingCart> result = underTest.findAllShoppingCarts();
		assertThat(result, contains(any(ShoppingCart.class)));
	}

}
