
package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CartItemMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private CartItemRepository cartItemRepo;

	@Resource
	private ShoppingCartRepository shoppingCartRepo;

	private CartItem testCartItem1;
	private CartItem testCartItem2;
	private CartItem testCartItem3;
	private Category testCategory;
	private Product product1;
	private Product product2;
	private ShoppingCart testCart;
	private ShoppingCart testCart2;

	@Before
	public void setup() {

		testCategory = new Category("cat", "so cool");
		testCategory = categoryRepo.save(testCategory);

		product1 = new Product("", "", "", 5, testCategory, "");
		product1 = productRepo.save(product1);
		product2 = new Product("", "", "", 4, testCategory, "");
		product2 = productRepo.save(product2);

		testCart = new ShoppingCart();
		testCart = shoppingCartRepo.save(testCart);
		testCart2 = new ShoppingCart();
		testCart2 = shoppingCartRepo.save(testCart2);

		testCartItem1 = new CartItem(product1, 5, testCart);
		testCartItem1 = cartItemRepo.save(testCartItem1);

		testCartItem2 = new CartItem(product1, 2, testCart);
		testCartItem2 = cartItemRepo.save(testCartItem2);

		testCartItem3 = new CartItem(product1, 1, testCart2);
		testCartItem3 = cartItemRepo.save(testCartItem3);

	}

	@Test
	public void shouldSaveOneProductToTwoCartItems() {

		long product1Id = product1.getId();

		flushAndClear();

		product1 = productRepo.findOne(product1Id);

		assertThat(product1.getCartItems(), hasItems(testCartItem1));
		assertThat(product1.getCartItems(), hasItems(testCartItem2));

	}

	@Test
	public void shouldSaveOneShoppingCartToTwoCartItems() {
		long cartId = testCart.getId();

		flushAndClear();

		testCart = shoppingCartRepo.findOne(cartId);

		assertThat(testCart.getCartItems(), hasItems(testCartItem1, testCartItem2));

	}

	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}

}
