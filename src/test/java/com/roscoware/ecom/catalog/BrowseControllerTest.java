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

import com.roscoware.ecom.catalog.BrowseController.SomethingNotFoundException;

public class BrowseControllerTest {
	@InjectMocks
	private BrowseController underTest;
	@Mock
	private ProductRepository productRepo;
	@Mock
	private CategoryRepository categoryRepo;
	@Mock
	private Product product;
	@Mock
	private Category category;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetProducts() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));
		Iterable<Product> result = underTest.findProducts();
		assertThat(result, contains(any(Product.class)));

	}

	@Test
	public void shouldGetProductsFromDb() {
		when(productRepo.findAll()).thenReturn(Collections.singleton(product));
		Iterable<Product> result = underTest.findProducts();
		assertThat(result, contains(product));

	}

	@Test
	public void shouldGetAnIndividualProductFromDb() {
		when(productRepo.findOne(30L)).thenReturn(product);
		Product result = underTest.findProduct(30L);

		assertThat(result, is(product));

	}

	@Test(expected = SomethingNotFoundException.class)
	public void shouldReturnNotFoundForBadProductId() {
		long invalidProductId = 42L;
		underTest.findProduct(invalidProductId);
	}

	@Test
	public void shouldGetCategoriesFromDb() {
		when(categoryRepo.findAll()).thenReturn(Collections.singleton(category));
		Iterable<Category> result = underTest.findCategories();
		assertThat(result, contains(category));
	}

	@Test
	public void shouldGetAnIndividualCategoryFromDb() {
		when(categoryRepo.findOne(30L)).thenReturn(category);
		Category result = underTest.findCategory(30L);
		assertThat(result, is(category));
	}

	@Test(expected = SomethingNotFoundException.class)
	public void shouldReturnNotFoundForBadCategoryId() {
		long invalidProductId = 42L;
		underTest.findCategory(invalidProductId);
	}
}
