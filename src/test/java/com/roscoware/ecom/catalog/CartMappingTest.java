package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Tests:
//shouldRetrieveCartById
//should save Many Products in one cart
//should have Many Carts with same product

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CartMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private CartRepository cartRepo;

	// @Test
	// public void shouldSaveAndLoadACartFromDbById() {

	// Long underTest = testCart.getId();
	//
	// entityManager.flush();
	// entityManager.clear();
	//
	// testCart = cartRepo.findOne(underTest);
	//
	// assertThat(testCart.getId(), is(underTest));
	// }

	// @Test
	// public void

	@Test
	public void shouldSaveTwoProductsToOneCart() {
		Category testCategory = new Category("cat", "so cool");
		testCategory = categoryRepo.save(testCategory);

		Product product1 = new Product("", "", "", 5, testCategory, "");
		product1 = productRepo.save(product1);
		Product product2 = new Product("", "", "", 4, testCategory, "");
		product2 = productRepo.save(product2);

		Cart testCart = new Cart(product1, product2);
		testCart = cartRepo.save(testCart);

		long testCartId = testCart.getId();

		entityManager.flush();
		entityManager.clear();

		testCart = cartRepo.findOne(testCartId);

		assertThat(testCart.getProducts(), containsInAnyOrder(product1, product2));

	}

}
