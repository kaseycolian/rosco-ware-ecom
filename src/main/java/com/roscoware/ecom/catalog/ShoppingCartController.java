package com.roscoware.ecom.catalog;

import javax.annotation.Resource;

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

}
