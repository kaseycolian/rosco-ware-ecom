package com.roscoware.ecom.catalog;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CatalogMappingTest {

	@Resource
	private CrudRepository<Category, Long> categoryRepo;
	@Resource
	private TestEntityManager entityManager;
	@Resource
	private CrudRepository<Product, Long> productRepo;
	private Category testCategory;
	private Product testProduct1;
	private Product testProduct2;

	@Before
	public void setup() {
		testCategory = new Category("Category Name", "This will be the category description.");
		testCategory = categoryRepo.save(testCategory);
		testProduct1 = new Product("Rosco Shorts", "Shorts", "This is our original short product.", 2.25, testCategory,
				"./images/sample1.jpg");
		testProduct1 = productRepo.save(testProduct1);
		testProduct2 = new Product("Rosco Pants", "Pants", "This is the pants version of our shorts.", 4.50,
				testCategory, "./images/sample1.jpg");
		testProduct2 = productRepo.save(testProduct2);
	}

	@Test
	public void shouldSaveAndLoadACategoryFromDb() {

		Long testId = testCategory.getId();
		flushAndClear();
		testCategory = categoryRepo.findOne(testId);
		assertThat(testCategory.getName(), is("Category Name"));
		assertThat(testCategory.getDescription(), is("This will be the category description."));
	}

	@Test
	public void shouldSaveAndLoadAProductFromDb() {
		testProduct1 = productRepo.save(testProduct1);
		Long testId = testProduct1.getId();
		flushAndClear();
		testProduct1 = productRepo.findOne(testId);
		assertThat(testProduct1.getName(), is("Rosco Shorts"));

	}

	@Test
	public void shouldSaveTwoProductsToOneCategory() {
		Long testId = testCategory.getId();
		flushAndClear();

		testCategory = categoryRepo.findOne(testId);

		Collection<Product> products = testCategory.getProducts();
		assertThat(products, containsInAnyOrder(testProduct1, testProduct2));

	}

	public void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
}
