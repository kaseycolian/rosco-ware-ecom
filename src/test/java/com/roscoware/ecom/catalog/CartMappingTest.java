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

//Tests:
//shouldRetrieveCartById

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

	private Cart testCart;
	private Cart testCart2;
	private Category testCategory;
	private Product product1;
	private Product product2;

	@Before
	public void setup() {

		testCategory = new Category("cat", "so cool");
		testCategory = categoryRepo.save(testCategory);

		product1 = new Product("", "", "", 5, testCategory, "");
		product1 = productRepo.save(product1);
		product2 = new Product("", "", "", 4, testCategory, "");
		product2 = productRepo.save(product2);

		testCart = new Cart(product1, product2);
		testCart = cartRepo.save(testCart);

		testCart2 = new Cart(product1);
		testCart2 = cartRepo.save(testCart2);

	}

	@Test
	public void shouldSaveOneProductToTwoCarts() {

		long product1Id = product1.getId();

		flushAndClear();

		product1 = productRepo.findOne(product1Id);

		assertThat(product1.getCarts(), hasItems(testCart));
		assertThat(product1.getCarts(), hasItems(testCart2));

	}

	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}

}
