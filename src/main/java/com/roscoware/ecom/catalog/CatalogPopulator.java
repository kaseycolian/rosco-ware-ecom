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
	@Resource
	private CartItemRepository cartItemRepo;
	@Resource
	private ShoppingCartRepository shoppingCartRepo;

	@Override
	public void run(String... args) throws Exception {
		Category clothing = new Category("Clothing", "Clothes for your beloved pets.");
		Category accessories = new Category("Accessories", "Things to make your pet's life better");
		clothing = categoryRepo.save(clothing);
		accessories = categoryRepo.save(accessories);
		Product roscoShorts = new Product("Rosco Shorts", "Shorts", "This is our original short product.", 2.25,
				clothing, "../images/dogshorts.jpg");
		Product roscoPants = new Product("Rosco Pants", "Pants", "This is the pants version of our shorts.", 4.50,
				clothing, "../images/dogpants.jpg");
		roscoShorts = productRepo.save(roscoShorts);
		roscoPants = productRepo.save(roscoPants);

		Product roscoCollar = new Product("Rosco Collar", "Collars",
				"This is a bejeweled collar that bedazzles all the dogs around.", 12.50, accessories,
				"../images/dogcollar.jpg");
		Product roscoLeash = new Product("Rosco Leash", "Leashes", "A leash fit for a royal dog at a peasant price.",
				8.75, accessories, "../images/dogleash.jpg");
		roscoCollar = productRepo.save(roscoCollar);
		roscoLeash = productRepo.save(roscoLeash);
		ShoppingCart cart = new ShoppingCart();
		cart = shoppingCartRepo.save(cart);
		ShoppingCart cart2 = new ShoppingCart();
		cart2 = shoppingCartRepo.save(cart2);
		CartItem cartItem1 = new CartItem(roscoShorts, 3, cart);
		CartItem cartItem2 = new CartItem(roscoLeash, 2, cart);
		CartItem cartItem3 = new CartItem(roscoPants, 1, cart);
		cartItem1 = cartItemRepo.save(cartItem1);
		cartItem2 = cartItemRepo.save(cartItem2);
		cartItem3 = cartItemRepo.save(cartItem3);
		CartItem cartItem4 = new CartItem(roscoShorts, 2, cart2);
		cartItem4 = cartItemRepo.save(cartItem4);
	}

}
