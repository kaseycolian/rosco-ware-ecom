package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


public class CartMappingTest {
	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private CartRepository cartRepo;

	@Test
	public void shouldSaveAndLoadACartFromDb() {
		Category testCategory = new Category("cat", "so cool");
		testCategory = categoryRepo.save(testCategory);
		Product product1 = new Product("", "", "", 5, testCategory);
		Cart testCart = new Cart(product1);

		Long underTest = testCart.getId();

		entityManager.flush();
		entityManager.clear();

		testCart = cartRepo.findOne(underTest);

		assertThat(testCart.getId(), is(underTest));

	}
}
