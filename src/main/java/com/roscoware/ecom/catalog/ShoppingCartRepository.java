package com.roscoware.ecom.catalog;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

//	Collection<ShoppingCart> saveCartItems (CartItem newCartItem);

}
