package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static java.math.BigDecimal.valueOf;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ShoppingCartControllerTest {

	private long cartId = 42L;

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
	private Model model;
	@Mock
	private Product product;
	@Mock
	private Category category;
	@Mock
	private CartItem cartItem;
	@Mock
	private ShoppingCart shoppingCart;
	
//	@Mock
//	Iterable<ShoppingCart> shoppingCarts;
	

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

	@Test
	public void shouldAddCartItemToShoppingCart() {
		when(shoppingCartRepo.findOne(cartId)).thenReturn(shoppingCart);
		ShoppingCart result = underTest.findShoppingCart(cartId);
		underTest.addCartItemsToShoppingCart(model, cartId, cartItem);
		verify(model).addAttribute("cartItem", result);
	}

}
