package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CatalogPopulator implements CommandLineRunner {
	@Resource
	private CategoryRepository categoryRepo;
	@Resource
	private ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {
		Category clothing = new Category("Clothing", "Clothes for your beloved pets.");
		Category accessories = new Category("Accessories", "Things to make your pet's life better");
		clothing = categoryRepo.save(clothing);
		accessories = categoryRepo.save(accessories);
		Product roscoShorts = new Product("Rosco Shorts", "Shorts", "This is our original short product.", 2.25,
				clothing, "./images/sample1.jpg");
		Product roscoPants = new Product("Rosco Pants", "Pants", "This is the pants version of our shorts.", 4.50,
				clothing, "./images/sample1.jpg");
		productRepo.save(roscoShorts);
		productRepo.save(roscoPants);

		Product roscoCollar = new Product("Rosco Collar", "Collars",
				"This is a bejeweled collar that bedazzles all the dogs around.", 12.50, accessories,
				"./images/sample1.jpg");
		Product roscoLeash = new Product("Rosco Leash", "Leashes", "A leash fit for a royal dog at a peasant price.",
				8.75, accessories, "./images/sample1.jpg");
		productRepo.save(roscoCollar);
		productRepo.save(roscoLeash);

	}

}
