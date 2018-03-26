package com.roscoware.ecom.catalog;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BrowseController.class)
public class CatalogMvcTest {
	@Resource
	MockMvc mvc;
	@MockBean
	private ProductRepository productRepo;
	@MockBean
	private CategoryRepository categoryRepo;

	@Test
	public void shouldRetrieveProducts() throws Exception {
		mvc.perform(get("/api/products")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveAnIndividualProduct() throws Exception {
		when(productRepo.findOne(42L)).thenReturn(new Product("some product"));
		mvc.perform(get("/api/products/42")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindProductId() throws Exception {
		mvc.perform(get("/api/products/42")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldRetrieveCategories() throws Exception {
		mvc.perform(get("/api/categories")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveAnIndividualCategory() throws Exception {
		when(categoryRepo.findOne(2L)).thenReturn(new Category("Some Category", "Category Description"));
		mvc.perform(get("/api/categories/2")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindCategoryId() throws Exception {
		mvc.perform(get("/api/categories/42")).andExpect(status().isNotFound());
	}
}
