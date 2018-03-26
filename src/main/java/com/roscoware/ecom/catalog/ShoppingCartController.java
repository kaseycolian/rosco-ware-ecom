package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

	@Resource
	private CartItemRepository cartItemRepo;

	@Resource
	private ShoppingCartRepository shoppingCartRepo;

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@RequestMapping("/shoppingCarts/{cartId}")
	public ShoppingCart findShoppingCart(@PathVariable(name = "cartId") long cartId) {
		ShoppingCart selectedCart = shoppingCartRepo.findOne(cartId);

		return selectedCart;
	}

	@RequestMapping("/shoppingCarts")
	public Iterable<ShoppingCart> findAllShoppingCarts() {
		return shoppingCartRepo.findAll();
	}

	@RequestMapping("/add-to-cart")
	public String addCartItemsToShoppingCart(Model model, Long shoppingCartId, CartItem cartItem) {

		Category category = new Category("category", "Category Description");
		categoryRepo.save(category);
		Product product = new Product("name", "type", "description", 20.00, category, "wwww.site.com");
		productRepo.save(product);
		ShoppingCart newShoppingCart = shoppingCartRepo.findOne(shoppingCartId);
		CartItem newCartItem = new CartItem(product, 1, newShoppingCart);
		cartItemRepo.save(newCartItem);
		shoppingCartRepo.save(newShoppingCart);

		model.addAttribute("cartItem", newShoppingCart);

		return "redirect:/shoppingCart?id=" + shoppingCartId;

	}

}
